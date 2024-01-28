package com.java2e.martin.common.bean.system;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import com.java2e.martin.common.core.annotation.BindField;
import com.java2e.martin.common.core.constant.CommonConstants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统操作
 * </p>
 *
 * @author 狮少
 * @version 1.0
 * @date 2021-08-06
 * @describtion
 * @since 1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_operation")
@ApiModel(value="Operation对象", description="系统操作")
public class Operation implements Serializable {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "操作名称")
    private String name;

    @ApiModelProperty(value = "权限编码")
    private String authority;

    @ApiModelProperty(value = "请求类型")
    private String flagRequestMethod;

    @ApiModelProperty(value = "后端权限url")
    private String url;

    @ApiModelProperty(value = "父操作id")
    private String parentId;

    @ApiModelProperty(value = "所属菜单")
    @BindField(entity = Menu.class, field = "name")
    private String menuId;

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "前端组件")
    private String component;

    @ApiModelProperty(value = "排序值")
    private Integer sort;

    @ApiModelProperty(value = "所属租户")
    private String tenantId;

    @ApiModelProperty(value = "删除标识（0-正常,1-删除）")
    @TableLogic
    private String delFlag;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "创建人")
    @TableField(fill = FieldFill.INSERT)
    @BindField(entity = User.class, field = CommonConstants.USER_USERNAME)
    private String creator;

    @ApiModelProperty(value = "修改人")
    @TableField(fill = FieldFill.UPDATE)
    @BindField(entity = User.class, field = CommonConstants.USER_USERNAME)
    private String updater;


}
