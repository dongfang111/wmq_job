package com.example.demo.pattern.chain;

/**
 * @author wmqing
 * @Date 2020/12/1 15:39
 **/
public class ResponsibilityTest {

    public static void main(String[] args) {
        LeaveRequest request = new LeaveRequest(20, "明");
        DirectLeaderLeaveHandler directLeaderLeaveHandler = new DirectLeaderLeaveHandler("县令");
        DeptManagerLeaveHandler deptManagerLeaveHandler = new DeptManagerLeaveHandler("知府");
        GManagerLeaveHandler gManagerLeaveHandler = new GManagerLeaveHandler("京兆尹");

        directLeaderLeaveHandler.setNextHandler(deptManagerLeaveHandler);
        deptManagerLeaveHandler.setNextHandler(gManagerLeaveHandler);

        directLeaderLeaveHandler.handlerRequest(request);
    }
}
