# 新疆公路建设指挥平台
## 运行
    npm install
    gulp


## 项目简介

## 技术栈
vue.js2.5、vue-router


## 遇见问题
* 错误信息：
```
[Vue warn]: You are using the runtime-only build of Vue where the template compiler is not available. Either pre-compile the templates into render functions, or use the compiler-included build
```
原因：  
    运行时构建不包含模板编译器，因此不支持 template 选项，只能用 render 选项，但即使使用运行时构建，在单文件组件中也依然可以写模板，因为单文件组件的模板会在构建时预编译为 render 函数。运行时构建比独立构建要轻量30%，只有 17.14 Kb min+gzip大小。
    上面一段是官方api中的解释。就是说，如果我们想使用template，我们不能直接在客户端使用npm install之后的vue。此时，再去看查vue模块，添加几行。   
解决：   
在webpack配置文件中添加
```   
    resolve: {
    alias: {
        'Vue': pwd + '/src/js/library/' + aliasFile('vue')
        } 
    }
```





