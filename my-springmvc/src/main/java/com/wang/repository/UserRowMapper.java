package com.wang.repository;

import com.wang.model.User;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Description:
 * All Rights Reserved.
 *
 * @version 1.0  2018/8/18 17:01  by  王帅（wangshuai@cloud-young.com）创建
 */
public   class UserRowMapper
        implements RowMapper{

//    public User mapRow(ResultSet rs, int rowNum)
//            throws SQLException{
//        return new User(
//                rs.getString("user_name")
//        );
//    }

    public int[] getRowsForPaths(TreePath[] path) {
        return new int[0];
    }
}
