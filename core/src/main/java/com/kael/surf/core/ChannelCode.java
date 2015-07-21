package com.kael.surf.core;

import com.kael.core.request.C2SMsg.UserInfoProto;
import com.kael.core.resp.S2CMsg.RespUserInfoProto;

public class ChannelCode {
	
	@Channel(type=ChannelType.C2S,proto=UserInfoProto.class,comment="请求玩家信息",serviceName="userService",methodName="getUserInfo")
	public static final short req_getUserInfo = 1;
	
	@Channel(type=ChannelType.S2C,proto=RespUserInfoProto.class)
	public static final short resp_getUserInfo = 10001;
}
