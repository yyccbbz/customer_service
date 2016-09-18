package org.blazer.bigclient.util;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 继承自己的MyMapper
 *
 * Created by cuican on 2016-8-25.
 */
public interface MyMapper<T> extends Mapper<T>,MySqlMapper<T> {
}
