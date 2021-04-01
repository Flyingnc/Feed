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
 * @since 2021-03-29
 */
@Data
@TableName("blade_feed_car")
@ApiModel(value = "FeedCar对象", description = "FeedCar对象")
public class FeedCar implements Serializable {

    private static final long serialVersionUID = 1L;


	/**
	 * 主键id
	 */
	@ApiModelProperty(value = "主键")
	@TableId(value = "id", type = IdType.ASSIGN_ID)
	@JsonSerialize(using = ToStringSerializer.class)
  	private Long id;
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
     * 车仓载重
     */
    @ApiModelProperty(value = "车仓载重")
    private String carBarnLoad;
    /**
     * 车载重
     */
    @ApiModelProperty(value = "车载重")
    private String carLoad;
    /**
     * 司机姓名
     */
    @ApiModelProperty(value = "司机姓名")
    private String driverName;
    /**
     * 司机手机号
     */
    @ApiModelProperty(value = "司机手机号")
    private String driverPhone;
    /**
     * 车辆所在地址
     */
    @ApiModelProperty(value = "车辆所在地址")
    private String carAddr;
    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private LocalDateTime creattime;
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updatetime;


}
