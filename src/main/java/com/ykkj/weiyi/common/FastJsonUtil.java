package com.ykkj.weiyi.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.alibaba.fastjson.serializer.ValueFilter;

import java.util.Arrays;

public class FastJsonUtil {

	public static String obj2Json(Object obj) {
		SimplePropertyPreFilter propertyPreFilter = new SimplePropertyPreFilter();
		propertyPreFilter.getExcludes().addAll(Arrays.asList(new String[] { "endRow","firstPage", "hasNextPage","hasPreviousPage","isFirstPage","isLastPage","lastPage","navigatepageNums","nextPage","size","prePage","startRow","navigatePages"}));

		SerializeFilter valueFilter = new ValueFilter() {
			public Object process(Object object, String name, Object value) {
				if (value == null)
					return "";
				return value;
			}
		};
		String json = JSON.toJSONString(obj, new SerializeFilter[] {
				propertyPreFilter, valueFilter },
				SerializerFeature.WriteMapNullValue,
				SerializerFeature.WriteDateUseDateFormat);
		return json;
	}
}
