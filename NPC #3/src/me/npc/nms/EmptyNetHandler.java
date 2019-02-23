package me.npc.nms;

import java.net.SocketAddress;

import net.minecraft.server.v1_8_R3.EnumProtocolDirection;
import net.minecraft.server.v1_8_R3.NetworkManager;

public class EmptyNetHandler extends NetworkManager {

	  public EmptyNetHandler() {
	    super(EnumProtocolDirection.CLIENTBOUND);
	    this.channel = new EmptyChannel();
	    this.l = new SocketAddress() {
			private static final long serialVersionUID = -475228594028486085L;
	    	
	    };
	}

}
