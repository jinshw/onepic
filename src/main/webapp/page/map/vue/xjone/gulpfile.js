'use strict';
var fs = require('fs');
var gulp = require('gulp');
var webpack = require('webpack');
var gulpWebpack = require('webpack-stream');
var uglify = require('gulp-uglify');
var minifyCss = require('gulp-minify-css');
var header = require('gulp-header');
var clean = require('gulp-clean');
var gulpIf = require('gulp-if');
var concat = require('gulp-concat');
var connect = require('gulp-connect');
var rename = require('gulp-rename');
var minimist = require('minimist');
var replace = require('gulp-replace');
var path = require('path')

var pwd = __dirname;

// gulp --env=pro 压缩代码，直接执行gulp，不压缩代码
var argv = require('minimist')(process.argv.slice(2));
var config = require('./config.json');

// 根据不同环境使用不同的第三方库
var aliasFile = function (name) {
    if (argv.env == 'pro') {
        return name + '.min.js';
    } else {
        return name + '.js';
    }
}

var vendorPlugin = new webpack.optimize.CommonsChunkPlugin({
    name: 'vendor',
    filename: 'vendor.min.js',
    minChunks: Infinity,
});

function resolve(dir) {
    return path.join(__dirname, '..', dir)
}

var webpackConfig = {
    entry: {
        xjone: './src/js/app.js',
        vendor: [
            pwd + '/src/js/library/' + aliasFile('vue'),
            pwd + '/src/js/library/' + aliasFile('jquery'),
            pwd + '/src/js/library/' + aliasFile('vue-router'),
            pwd + '/src/js/library/' + aliasFile('vuex'),
            pwd + '/src/js/library/' + aliasFile('jquery-qrcode'),
            pwd + '/src/js/library/' + aliasFile('jquery-popline'),
            pwd + '/src/js/library/' + aliasFile('lodash')
        ]
    },
    output: {
        filename: '[name].min.js'
    },
    module: {
        loaders: [{
            test: /.js$/,
            loader: 'jsx-loader?harmony'
        }, {
            test: /.vue$/,
            loader: 'vue-loader',
            exclude: /node_modules/
        },
        {
            test: /\.js$/,
            loader: 'babel-loader',
            exclude: /node_modules/,
            query: {
                presets: ['es2015']
            }
        }, {
            test: /\.css$/,
            loader: "style-loader!css-loader"
        },
        {
            test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
            loader: 'url-loader'
        },
        {
            test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
            loader: 'url-loader'
        }
        ]

    },
    plugins: [vendorPlugin,
        // 3. 配置全局使用 jquery
        new webpack.ProvidePlugin({
            $: "jQuery",
            jQuery: "jQuery",
            jquery: "jQuery",
            "window.jQuery": "jQuery"
        })
    ],
    resolve: {
        extensions: ['', '.js', '.json', '.scss'],
        alias: {
            'Vue': pwd + '/src/js/library/' + aliasFile('vue'),
            // 'Vuex': pwd + '/src/js/library/' + aliasFile('vuex'),
            'jQuery': pwd + '/src/js/library/' + aliasFile('jquery'),
            '$': pwd + '/src/js/library/' + aliasFile('jquery'),
            // 'vue-route': pwd + '/src/js/library/' + aliasFile('vue-router'),
            'utils': pwd + '/src/js/util/index.js',
            'qrcode': pwd + '/src/js/library/' + aliasFile('jquery-qrcode'),
            'popline': pwd + '/src/js/library/' + aliasFile('jquery-popline'),
            'lodash': pwd + '/src/js/library/' + aliasFile('lodash'),
            '@': resolve('src'),
        }
    },
};

// 公共头部
var banner = ['/**',
    ' * <%= config.name %> - <%= config.description %>',
    ' * @version v<%= config.version %>',
    ' */',
    ''
].join('\n');

gulp.task('cleanCSS', function () {
    return gulp
        .src(['./dist/css/*.css'], { read: false })
        .pipe(clean({ force: true }))
});
gulp.task('cleanJS', function () {
    return gulp
        .src(['./dist/js/*.js'], { read: false })
        .pipe(clean({ force: true }))
});
gulp.task('cleanStaticJS', function () {
    return gulp
        .src(['./dist/static/js/*.js'], { read: false })
        .pipe(clean({ force: true }))
});

gulp.task('js', function () {
    return gulp
        .src('./src/js/app.js')
        .pipe(gulpWebpack(webpackConfig))
        .pipe(gulpIf(argv.env == 'pro', uglify()))
        .pipe(gulpIf(argv.env == 'pro', header(banner, { config: config })))
        .pipe(gulp.dest('./dist/js/'))
        .pipe(connect.reload())
})

gulp.task('staticJS', function () {
    var _paths = [
        "./src/js/config/xjone-map-all.js",
        "./src/js/config/ajaxRequest.js",
        "./src/js/config/xjone-echarts.js"
    ]
    return gulp
        .src(_paths)
        .pipe(gulp.dest('./dist/static/js/'))
        .pipe(connect.reload())
})

gulp.task('css', function () {
    return gulp
        .src('./src/css/*.css')
        .pipe(concat('all.css'))
        .pipe(gulpIf(argv.env == 'pro', minifyCss()))
        .pipe(gulpIf(argv.env == 'pro', header(banner, { config: config })))
        .pipe(rename('xjone.min.css'))
        .pipe(gulp.dest('./dist/css/'))
        .pipe(connect.reload());
})

gulp.task('img', function () {
    return gulp
        .src('./src/img/*')
        .pipe(gulp.dest('./dist/img/'))
        .pipe(connect.reload())
})
gulp.task('fonts', function () {
    return gulp
        .src('./src/fonts/*')
        .pipe(gulp.dest('./dist/fonts/'))
        .pipe(connect.reload())
})

gulp.task('rev', function () {
    return gulp
        .src('./index.html')
        .pipe(gulpIf(argv.env == 'pro', replace(/xjone.min.css[\s\S]*?"/, 'xjone.min.css?ver=' + config.version + '"')))
        .pipe(gulpIf(argv.env == 'pro', replace(/xjone.min.js[\s\S]*?"/, 'xjone.min.js?ver=' + config.version + '"')))
        .pipe(gulpIf(argv.env == 'pro', replace(/vendor.min.js[\s\S]*?"/, 'vendor.min.js?ver=' + config.version + '"')))
        .pipe(gulp.dest('./'))
        .pipe(connect.reload())
})

gulp.task('watch', function () {
    webpackConfig.watch = argv.env != 'pro';
    gulp.watch('./src/js/**/**/**/*', ['js']);
    gulp.watch('./src/js/config/*.js', ['staticJS']);
    gulp.watch('./src/css/*', ['css']);
    gulp.watch('./src/img/*', ['img']);
    gulp.watch('./src/fonts/*', ['fonts']);
})


//clean、liverload、watch
gulp.task('connect', function () {
    connect.server({
        root: '',
        port: '8333',
        livereload: true
    });
});

gulp.task('default', ['cleanCSS','cleanJS','cleanStaticJS'], function () {
    gulp.start(['js','staticJS', 'css', 'img', 'fonts', 'rev', 'connect', 'watch']);
});