package com.kael.surf.server;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import com.kael.surf.core.Channel;
import com.kael.surf.core.ChannelCode;
import com.kael.surf.core.ChannelType;
import com.kael.surf.core.Req;

public class Dispacter {

	private static Map<String, Short> respDispacters = new HashMap<String, Short>();
	private static Map<Short, Req> reqDispacters = new HashMap<Short, Req>();

	static {
		ChannelCode cc = ChannelCode.me();
		Field[] fs = cc.getFields().toArray(new Field[0]);

		for (Field field : fs) {
			Channel channel = field.getAnnotation(Channel.class);

			if (channel.type() == ChannelType.C2S) {
				try {
					reqDispacters.put(field.getShort(cc), Req.parse(channel));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					respDispacters.put(channel.proto().getName(), field.getShort(cc));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static Req getClassByCode(short code) {
		return reqDispacters.get(code);
	}

	public static short getCodeByClaName(String clazName) {
		return respDispacters.get(clazName);
	}
}
