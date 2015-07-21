package com.kael.surf.server.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import com.kael.surf.core.IMessage;

public class SimpleChannelInboundHandlerAdapter extends
		ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg)
			throws Exception {
		if(!(msg instanceof IMessage)){
			System.out.println(msg.getClass().getName());
			return ;
		}
		
	}

}
