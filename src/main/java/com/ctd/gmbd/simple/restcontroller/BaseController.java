package com.ctd.gmbd.simple.restcontroller;

import com.ctd.gmbd.simple.repository.AuthUserEntity;
import com.ctd.gmbd.simple.restcontroller.serializer.JsonUserSerializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseController {
	private final static Gson gson;
	static {
		final GsonBuilder builder = new GsonBuilder();
		builder.excludeFieldsWithoutExposeAnnotation();
		builder.setPrettyPrinting();
		builder.serializeNulls();
		builder.setDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		builder.registerTypeAdapter(AuthUserEntity.class, new JsonUserSerializer());
		builder.serializeSpecialFloatingPointValues();

		gson = builder.create();
	}

	protected Gson getGson() {
		return gson;
	}
}
