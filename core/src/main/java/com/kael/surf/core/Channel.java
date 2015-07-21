package com.kael.surf.core;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.protobuf.GeneratedMessage;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
public @interface Channel {

	ChannelType type() default ChannelType.C2S;
	
	Class<? extends GeneratedMessage> proto();
	
	String comment() default "";
}
