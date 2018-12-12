/**
 * 从对象数组中删除属性为objPropery，值为objValue元素的对象
 * @param Array arrPerson  数组对象
 * @param String objPropery  对象的属性
 * @param String objPropery  对象的值
 * @return Array 过滤后数组
 */
function remove(arrPerson,objPropery,objValue)
{
    return $.grep(arrPerson, function(cur,i){
        return cur[objPropery]!=objValue;
    });
}
/**
 * 从对象数组中获取属性为objPropery，值为objValue元素的对象
 * @param Array arrPerson  数组对象
 * @param String objPropery  对象的属性
 * @param String objPropery  对象的值
 * @return Array 过滤后的数组
 */
function get(arrPerson,objPropery,objValue)
{
    return $.grep(arrPerson, function(cur,i){
        return cur[objPropery]==objValue;
    });
}