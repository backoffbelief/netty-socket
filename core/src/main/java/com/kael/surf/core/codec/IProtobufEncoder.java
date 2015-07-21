package com.kael.surf.core.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import com.google.protobuf.GeneratedMessage;
import com.kael.surf.core.IMessage;

/**
 * @author hanyuanliang
 * 2015-7-21 下午3:02:19 
 */
public class IProtobufEncoder extends MessageToByteEncoder<IMessage> {
	@Override
	protected void encode(ChannelHandlerContext ctx, IMessage msg, ByteBuf out)
			throws Exception {
		GeneratedMessage gm = msg.getGm();
		short code = msg.getCode();
		byte[] bytes = gm.toByteArray();
		int len = 6 + bytes.length;
		ByteBuf buf = Unpooled.buffer(len);
		buf.writeInt(len);
		buf.writeShort(code);
		buf.writeBytes(bytes);
        out.writeBytes(buf, buf.readerIndex(), len);
		
	}
}
