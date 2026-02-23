package com.ctd.gmbd.simple.restcontroller.serializer;

import java.lang.reflect.Type;

import com.ctd.gmbd.simple.repository.AuthUserEntity;
import com.ctd.gmbd.simple.restcontroller.dto.AuthUserDto;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class JsonUserSerializer implements JsonSerializer<AuthUserEntity> {

	@Override
	public JsonElement serialize(AuthUserEntity src, Type typeOfSrc, JsonSerializationContext context) {
		AuthUserDto authUserDto = new AuthUserDto(src.getId(), src.getName());
		return context.serialize(authUserDto);
	}
}
