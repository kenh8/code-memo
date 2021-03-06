package edu.hfut.pool2;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * 管理{@link PooledObject} 的生命周期
 * @author donglei
 * @date: 2016年1月21日 上午10:32:42
 */
public class StringBufferFactory extends BasePooledObjectFactory<StringBuffer> {

	@Override
	public StringBuffer create() {
		return new StringBuffer();
	}

	/**
	 * Use the default PooledObject implementation.
	 */
	@Override
	public PooledObject<StringBuffer> wrap(StringBuffer buffer) {
		return new DefaultPooledObject<StringBuffer>(buffer);
	}

	/**
	 * When an object is returned to the pool, clear the buffer.
	 */
	@Override
	public void passivateObject(PooledObject<StringBuffer> pooledObject) {
		System.out.println("passivateObject has been called!");
		pooledObject.getObject().setLength(0);
	}

	// for all other methods, the no-op implementation
	// in BasePooledObjectFactory will suffice

	/**
	 *  No-op.
	 *
	 *  @param p ignored
	 */
	@Override
	public void destroyObject(PooledObject<StringBuffer> p) throws Exception {
		System.out.println("destroyObject has been called!");
	}

	/**
	 * This implementation always returns {@code true}.
	 *
	 * @param p ignored
	 *
	 * @return {@code true}
	 */
	@Override
	public boolean validateObject(PooledObject<StringBuffer> p) {
		System.out.println("validateObject has been called!");
		return true;
	}

	/**
	 *  No-op.
	 *
	 *  @param p ignored
	 */
	@Override
	public void activateObject(PooledObject<StringBuffer> p) throws Exception {
		System.out.println("validateObject has been called!");
	}

}