package com.kael.surf.core;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

import com.kael.core.request.C2SMsg.UserInfoProto;
import com.kael.core.resp.S2CMsg.RespUserInfoProto;

public class ChannelCode {
	
	private ChannelCode(){}
	private static final ChannelCode instance = new ChannelCode();
	
	public static ChannelCode me(){
		return instance;
	}
	@Channel(type=ChannelType.C2S,proto=UserInfoProto.class,comment="请求玩家信息",serviceName="userService",methodName="getUserInfo")
	public final short req_getUserInfo = 1;

//	@Channel(type=ChannelType.C2S,proto=UserInfoProto.class,comment="请求玩家信息",serviceName="userService",methodName="getUserInfo")
//	public final short req_getUserInfo0 = 1;
	
	@Channel(type=ChannelType.S2C,proto=RespUserInfoProto.class)
	public final short resp_getUserInfo = 10001;

	public Set<Field> getFields(){
		Field[] fs = ChannelCode.class.getDeclaredFields();
		Set<Field> fields = new HashSet<Field>(fs.length);
		Set<Short> ss = new HashSet<Short>();
		for(Field f : fs){
			if(f.isAnnotationPresent(Channel.class)){
				try {
					if(!f.isAccessible()){
						f.setAccessible(true);
					}
					
					if(!ss.add(f.getShort(this))){
						throw new RuntimeException("repeated------------"+f.getShort(this)+",----"+f.getName());
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				fields.add(f);
			}
		}
		return fields;
	}
	
	public static void main(String[] args) {
		me().getFields();
	}
}
