package com.kael.surf.core.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

import com.kael.surf.core.IMessage;

/**
 * @author hanyuanliang
 * 2015-7-21 下午2:57:23 
 */
public class IProtobufDecoder extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf msg,
			List<Object> out) throws Exception {
		ByteBuf buf = Unpooled.copiedBuffer(msg);
		short code = buf.readShort();
		byte[] dst = new byte[buf.readableBytes()];
		msg.readBytes(dst, buf.readerIndex(), buf.readableBytes());
		out.add(IMessage.newBuilder().withCode(code).withBody(dst).build());
	}
}
