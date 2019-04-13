package com.yxw.travel.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * @Author:阿倪
 * @Date: 2019/3/27 20:18
 * @Description: 组队信息实体类
 * @return:
 * @throws:
 */
public class GoTravelGroup implements Serializable {

    private static final long serialVersionUID = 565397193433807472L;

    private int groupId;//    group_id
    private String groupName;//            group_name 团队名称
    private String groupStartLine; //    group_start_line 预计出发起点(应该三级联动实现A_B_C)
    private String groupEndLine;//            group_end_line预计结束终点
    private Date createTime;//    create_time 数据插入时间
    private Date updateTime;//            update_time 插入数据被修改时间
    private Date groupUpStratTime;//    group_up_start_time 组队信息开始在网站公布时间,其他用户可以看到此组队信息
    private Date groupUpEndTime;//            group_up_end_time 组队信息停止其他用户参与组队结束时间,说明已经超时或者组队已经完成
    private Date groupTravelStartTime;//    group_travel_start_time 该组队预计出发时间
    private Date groupTravelEndTime;//            group_travel_end_time 该组队预计返回时间
    private String groupInformation;//    group_information 团队标语,介绍等
    private String comment;//            comment备注
    private String goWay;//           go_way 出行方式
    private int groupState; //    group_state成团状态(枚举类获取TravelGroupState)
    private int stuId;//            stu_id组队发起人id
    private int memberNum;//member_num 预计成员数量

    public int getMemberNum() {
        return memberNum;
    }

    public void setMemberNum(int memberNum) {
        this.memberNum = memberNum;
    }

    public String getGoWay() {
        return goWay;
    }

    public void setGoWay(String goWay) {
        this.goWay = goWay;
    }


    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupStartLine() {
        return groupStartLine;
    }

    public void setGroupStartLine(String groupStartLine) {
        this.groupStartLine = groupStartLine;
    }

    public String getGroupEndLine() {
        return groupEndLine;
    }

    public void setGroupEndLine(String groupEndLine) {
        this.groupEndLine = groupEndLine;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getGroupUpStratTime() {
        return groupUpStratTime;
    }

    public void setGroupUpStratTime(Date groupUpStratTime) {
        this.groupUpStratTime = groupUpStratTime;
    }

    public Date getGroupUpEndTime() {
        return groupUpEndTime;
    }

    public void setGroupUpEndTime(Date groupUpEndTime) {
        this.groupUpEndTime = groupUpEndTime;
    }

    public Date getGroupTravelStartTime() {
        return groupTravelStartTime;
    }

    public void setGroupTravelStartTime(Date groupTravelStartTime) {
        this.groupTravelStartTime = groupTravelStartTime;
    }

    public Date getGroupTravelEndTime() {
        return groupTravelEndTime;
    }

    public void setGroupTravelEndTime(Date groupTravelEndTime) {
        this.groupTravelEndTime = groupTravelEndTime;
    }

    public String getGroupInformation() {
        return groupInformation;
    }

    public void setGroupInformation(String groupInformation) {
        this.groupInformation = groupInformation;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getGroupState() {
        return groupState;
    }

    public void setGroupState(int groupState) {
        this.groupState = groupState;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }
}
