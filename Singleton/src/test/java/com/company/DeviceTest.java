package com.company;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nikita
 */
public class DeviceTest {
    
    public DeviceTest() {
    }

    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testTurnON() {
        System.out.println("turnON");
        Singleton state = Singleton.instance();
        Device instance = new DeviceImpl("Test");
        String device = "test";
        instance.turnON(device);
            assertTrue(instance.flag);
            assertTrue(state.getIsOn());

    }

    @Test
    public void testTurnOff() {
        System.out.println("turnOff");
        Singleton state = Singleton.instance();
        Device instance = new DeviceImpl("Test");
        instance.turnOff();
        assertFalse(instance.flag);
        assertFalse(state.getIsOn());
    }

    @Test
    public void testGetBuffer() {
        System.out.println("getBuffer");
        Device instance = new DeviceImpl("Test");
        instance.getBuffer();

    }

    @Test
    public void testUse() {
        System.out.println("use");
        Device instance = new DeviceImpl("Test");
        instance.use("test");



    }

    public static class DeviceImpl extends Device {

        public DeviceImpl(String device) {
            super(device);
        }

        public void use(String device) {
            Device instance = new DeviceImpl("Test");
            System.out.println(instance.buffer);
        }

        @Override
        public String toString() {

            if (flag) {
                return "Device{" +
                        "id='" + getId() + '\'' +
                        ", name='" + getDevice() + '\'' +
                        ", enabled=" + flag +
                        '}';
            }else {
                return null;
            }
        }
    }
    
}
