package com.ykkj.weiyi.util;


import org.apache.commons.lang.StringUtils;

import com.ykkj.weiyi.common.StaticUtils;

import net.coobird.thumbnailator.Thumbnails;

public class ThumbnailUtil {

	public static boolean makeThumbnail(String path,String size){
		boolean result = true;
//		String s = StaticUtils.THUMBNAIL_SIZE_S;
		String s = "";
		if(StringUtils.isNotBlank(size)){
			s=size;
		}
		/*String s = "100*80";
		String m = "120*120";
		String l = "400*280";*/
		System.out.println(path);
		String sufix = path.substring(path.lastIndexOf("."));
		String fileName = path.substring(path.lastIndexOf("/"));
		String name = path.substring(path.lastIndexOf("/"), path.lastIndexOf("."));
		String s_path = path.replace(fileName, name+"_s"+sufix);
		try {
			Thumbnails.of(path).size(Integer.parseInt(s.split("\\*")[0]), Integer.parseInt(s.split("\\*")[1])).keepAspectRatio(true).toFile(s_path);
		} catch (Exception e) {
			result = false;
			e.printStackTrace();
		}
		return result;
	}
	public static void main(String[] args){
		makeThumbnail("D:/2.jpg",null);
	}
}
