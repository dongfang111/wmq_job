package com.example.demo.pattern.chain;

/**
 * 总经理处理类
 *
 * @author wmqing
 * @Date 2020/12/1 15:28
 **/
public class GManagerLeaveHandler extends AbstractLeaveHandler {

    public GManagerLeaveHandler(String name) {
        this.handleName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if (request.getLeaveDays() > this.MIDDLE && request.getLeaveDays() <= this.MAX) {
            System.out.println("总经理:" + handleName + ",已经处理;流程结束。");
            return;
        }

        if (null != this.nextHandler) {
            this.nextHandler.handlerRequest(request);
        } else {
            System.out.println("审批拒绝！");
        }
    }
}
