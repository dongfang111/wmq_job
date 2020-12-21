package com.example.demo.pattern.chain;

/**
 * 部门经理处理类
 *
 * @author wmqing
 * @Date 2020/12/1 15:25
 **/
public class DeptManagerLeaveHandler extends AbstractLeaveHandler {

    public DeptManagerLeaveHandler(String name) {
        this.handleName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if (request.getLeaveDays() > this.MIN && request.getLeaveDays() <= this.MIDDLE) {
            System.out.println("部门经理:" + handleName + ",已经处理;流程结束。");
            return;
        }

        if (null != this.nextHandler) {
            this.nextHandler.handlerRequest(request);
        } else {
            System.out.println("审批拒绝！");
        }
    }
}
