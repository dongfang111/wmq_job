package com.example.demo.pattern.chain;

/**
 * 直接主管处理类
 *
 * @author wmqing
 * @Date 2020/12/1 11:51
 **/
public class DirectLeaderLeaveHandler extends AbstractLeaveHandler {

    public DirectLeaderLeaveHandler(String name) {
        this.handleName = name;
    }

    @Override
    protected void handlerRequest(LeaveRequest request) {
        if (request.getLeaveDays() <= this.MIN) {
            System.out.println("直接主管：" + handleName + "已经处理；流程完毕");
            return;
        }

        if (null != this.nextHandler) {
            this.nextHandler.handlerRequest(request);
        } else {
            System.out.println("审核拒绝！");
        }
    }
}
