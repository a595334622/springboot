package com.wh.utils;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;
/**
 * Json转换工具类
 * @ClassName: JsonUtil 
 * @Description: TODO 实体转json json转实体工具类
 * @author: 59533
 * @date: 2018年8月17日 下午1:05:15
 */
public final class JsonUtil {

	public static ObjectMapper objectMapper = new ObjectMapper();

	public static boolean validate(String json) {
		try {
			objectMapper.readTree(json);
			return true;
		} catch (JsonProcessingException e) {

			return false;
		} catch (IOException e) {
			return false;
		}

	}

	public static String toJson(Object value) {
		try {
			return objectMapper.writeValueAsString(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T toObject(String json, Class<T> valueType) {

		try {
			return objectMapper.readValue(json, valueType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T toObject(String json, TypeReference<?> typeReference) {

		try {
			return objectMapper.readValue(json, typeReference);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T toObject(String json, JavaType javaType) {

		try {
			return objectMapper.readValue(json, javaType);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}