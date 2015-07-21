package com.kael.surf.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import com.kael.surf.server.handler.SimpleChannelInitializer;

public class AppServer {

	public static void main(String[] args) {
		EventLoopGroup parentGroup = new NioEventLoopGroup();
		EventLoopGroup childGroup = new NioEventLoopGroup();
		
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(parentGroup, childGroup).channel(NioServerSocketChannel.class)
			         .childHandler(new SimpleChannelInitializer()).option(ChannelOption.SO_BACKLOG, 128)
			         .childOption(ChannelOption.SO_KEEPALIVE, true);
			ChannelFuture f = bootstrap.bind(8081).sync();
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally{
			childGroup.shutdownGracefully();
			parentGroup.shutdownGracefully();
		}
	}
}
