package com.opv2.zapt.framework.datapermission.core.util;

import com.opv2.zapt.framework.datapermission.core.aop.DataPermissionContextHolder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataPermissionUtilsTest {

    @Test
    public void testExecuteIgnore() {
        DataPermissionUtils.executeIgnore(() -> assertFalse(DataPermissionContextHolder.get().enable()));
    }

}
