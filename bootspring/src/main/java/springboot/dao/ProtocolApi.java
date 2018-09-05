package springboot.dao;

import springboot.model.Protocol;

public interface ProtocolApi {
	
	public boolean save(Protocol device);
	public Protocol getDive(Protocol device);

}
