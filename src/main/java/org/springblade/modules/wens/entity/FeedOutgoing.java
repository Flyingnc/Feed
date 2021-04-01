/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.modules.wens.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 实体类
 *
 * @author Blade
 * @since 2021-03-22
 */
@Data
@TableName("blade_feed_outgoing")
@ApiModel(value = "FeedOutgoing对象", description = "FeedOutgoing对象")
public class FeedOutgoing implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * 主键id
	 */
	@ApiModelProperty(value = "主键")
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
  	private Long id;
    /**
     * 需求单位
     */
    @ApiModelProperty(value = "需求单位")
    private String org;
    /**
     * 车牌号
     */
    @ApiModelProperty(value = "车牌号")
    private String carPlate;
    /**
     * 车仓号
     */
    @ApiModelProperty(value = "车仓号")
    private String carBarn;
    /**
     * 发料口
     */
    @ApiModelProperty(value = "发料口")
    private String spout;
    /**
     * 养户姓名
     */
    @ApiModelProperty(value = "养户姓名")
    private String userName;
    /**
     * 311
     */
    @ApiModelProperty(value = "311")
    private Double feed311;
    /**
     * 312前
     */
    @ApiModelProperty(value = "312前")
    private Double feed312bf;
    /**
     * 312中
     */
    @ApiModelProperty(value = "312中")
    private Double feed313md;
    /**
     * 312后
     */
    @ApiModelProperty(value = "312后")
    private Double feed312at;
    /**
     * 314大
     */
    @ApiModelProperty(value = "314大")
    private Double feed314bg;
    /**
     * 315大
     */
    @ApiModelProperty(value = "315大")
    private Double feed315bg;
    /**
     * 313后备
     */
    @ApiModelProperty(value = "313后备")
    private Double feed313rs;
    /**
     * 332怀
     */
    @ApiModelProperty(value = "332怀")
    private Double feed332pg;
    /**
     * 333哺乳
     */
    @ApiModelProperty(value = "333哺乳")
    private Double feed333ns;
    /**
     * 335种公
     */
    @ApiModelProperty(value = "335种公")
    private Double feed335sm;
    /**
     * 出料状态（0-未出料，1-已出料）
     */
    @ApiModelProperty(value = "出料状态（0-未出料，1-已出料）")
    private Integer status;
    /**
     * 新建时间
     */
    @ApiModelProperty(value = "新建时间")
    private LocalDateTime creattime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatetime;
	/**
	 * 领料时间
	 */
	@ApiModelProperty(value = "领料时间")
	private LocalDate outtime;
}
