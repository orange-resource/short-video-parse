package com.ongsat.video.web.common.response;

import lombok.Getter;

/**
 * code码
 * 基础操作码 1 - 999
 * 成功 1000 - 2999
 * 提醒 3000 - 4999
 * 失败 5000 - 7999
 * @author orange <1067357662@qq.com>
 */
@Getter
public enum RspCode {

    // 基础操作码
    SUCCESS(200, "操作成功"),
    ERROR(201, "操作失败"),
    QUERY_SUCCESS(200, "查询成功"),
    QUERY_ERROR(201, "查询失败"),
    VERIFICATION_FAILED(401, "验证失败，没有足够的权限进行访问"),
    INTERFACE_CLOSED(401, "此接口暂时不接受访问"),
    NOT_FOUND(404, "not found"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED(405, "请求错误，未找到指定资源"),
    PARAMETER_ERROR(406, "提交参数不合法"),
    SUBMISSION_AGREEMENT_ERROR(406, "提交协议不合法"),
    CONTENT_IS_TOO_LARGE(413, "提交内容过大"),
    UNKNOWN(500, "发生了一个未知错误"),

    LOGIN_SUCCESS(1000, "登录成功"),
    UPLOAD_SUCCESS(1001, "上传成功"),
    LOGOUT_SUCCESS(1002, "登出成功"),

    LOGIN_EXPIRED(3000, "凭证已过期，请重新登录"),
    FILE_TYPE_DOES_NOT_MATCH(3001, "上传文件格式不正确"),
    IMG_CONTENT_IS_TOO_LARGE(3011, "上传图片大小不能超过2MB哟"),
    VIDEO_CONTENT_IS_TOO_LARGE(3012, "上传视频大小不能超过5MB哟"),
    REPEAT_ITEM(3013, "不能添加重复项"),
    VERIFY_CODE_NOT_EXIST(3014, "验证码不存在"),

    ACCOUNT_ERROR(5001, "用户名或者密码错误"),
    UPLOAD_ERROR(5002, "上传失败"),
    FILE_EMPTY(5003, "不能上传空文件"),
    ;

    private int code;
    private String message;

    RspCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
