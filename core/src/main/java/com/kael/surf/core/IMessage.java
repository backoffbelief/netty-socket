package com.kael.surf.core;

import com.google.protobuf.GeneratedMessage;

public class IMessage {
	private short code;
	private byte[] body;

	private GeneratedMessage gm;

	private IMessage() {
	}

	public static Builder newBuilder() {
		return new Builder();
	}

	public static class Builder {
		private final IMessage msg;

		private Builder() {
			super();
			this.msg = new IMessage();
		}

		public Builder withCode(short code) {
			msg.code = code;
			return this;
		}

		public Builder withBody(byte[] bytes) {
			msg.body = bytes;
			return this;
		}

		public Builder withBody(GeneratedMessage gm) {
			msg.gm = gm;
			return this;
		}

		public IMessage build() {
			return msg;
		}
	}

	public short getCode() {
		return code;
	}

	public byte[] getBody() {
		return body;
	}

	public GeneratedMessage getGm() {
		return gm;
	}

}
