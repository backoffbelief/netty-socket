package com.kael.surf.server.handler;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

import com.kael.surf.core.codec.IProtobufDecoder;
import com.kael.surf.core.codec.IProtobufEncoder;

/**
 * @author hanyuanliang
 * 2015-7-21 下午3:22:30 
 */
public class SimpleChannelInitializer extends ChannelInitializer<SocketChannel> {

	private static final int maxFrameLength = 4096*4096;
	private static final int lengthFieldOffset = 0;
	private static final int lengthFieldLength = 4;
	private static final int lengthAdjustment = 0;
	private static final int initialBytesToStrip = 4;
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {

		ch.pipeline().addLast(new LengthFieldBasedFrameDecoder(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip));
		ch.pipeline().addLast(new IProtobufDecoder());
		ch.pipeline().addLast(new IProtobufEncoder());
		ch.pipeline().addLast(new SimpleChannelInboundHandlerAdapter());
	}

}
