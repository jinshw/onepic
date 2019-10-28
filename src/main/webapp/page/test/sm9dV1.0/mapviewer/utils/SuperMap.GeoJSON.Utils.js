 
var GeoJSON = {};
GeoJSON.flatten=function(array) {
    return [].concat.apply([], array);
}

GeoJSON.polygonToLineString=function(coordinates, properties) {
    return coordinates.map(function(coordinates) {
        return turf.lineString(coordinates, properties);
    });
}

GeoJSON.multiPolygonToLineString=function(coordinates, properties) {
    return GeoJSON.flatten(coordinates.map(function(coordinates) {
        return GeoJSON.polygonToLineString(coordinates, properties);
    }));
}

GeoJSON.toLineString=function(feature) {
    var geometry = feature.geometry,
        properties = feature.properties;

    switch (geometry.type) {
        case 'Polygon':
            return GeoJSON.polygonToLineString(geometry.coordinates, properties);
        case 'MultiPolygon':
            return GeoJSON.multiPolygonToLineString(geometry.coordinates, properties);
        default:
            return feature;
    }
}
/**
 * Transforms Polygons and MultiPolygons to LineStrings.
 *
 * @module turf/polygonToLine
 * @category transformation
 * @param {Object} geojson any GeoJSON object
 * @returns {Object} FeatureCollection where
 * Polygons and MultiPolygons transformed to LineStrings.
 */
GeoJSON.polygon2line=function(geojson) {
    var features = geojson.features.map(GeoJSON.toLineString);
    return turf.featureCollection(flatten(features));
}