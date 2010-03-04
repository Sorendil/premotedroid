package org.pierre.remotedroid.client.connection;

import org.pierre.remotedroid.protocol.tcp.PRemoteDroidConnectionTcp;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class ConnectionWifi extends Connection
{
	private String host;
	private int port;
	
	public ConnectionWifi()
	{
		super();
		
		this.host = "192.168.0.1";
		this.port = PRemoteDroidConnectionTcp.DEFAULT_PORT;
	}
	
	public static ConnectionWifi load(SharedPreferences preferences, int position)
	{
		ConnectionWifi connection = new ConnectionWifi();
		
		connection.host = preferences.getString("connection_" + position + "_host", null);
		
		connection.port = preferences.getInt("connection_" + position + "_port", 0);
		
		return connection;
	}
	
	public void save(Editor editor, int position)
	{
		super.save(editor, position);
		
		editor.putString("connection_" + position + "_type", "wifi");
		
		editor.putString("connection_" + position + "_host", this.host);
		
		editor.putInt("connection_" + position + "_port", this.port);
	}
	
	public String getHost()
	{
		return host;
	}
	
	public void setHost(String host)
	{
		this.host = host;
	}
	
	public int getPort()
	{
		return port;
	}
	
	public void setPort(int port)
	{
		this.port = port;
	}
}
