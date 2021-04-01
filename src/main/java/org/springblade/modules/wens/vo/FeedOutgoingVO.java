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
package org.springblade.modules.wens.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springblade.modules.wens.entity.FeedOutgoing;
import lombok.Data;
import lombok.EqualsAndHashCode;
import io.swagger.annotations.ApiModel;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 视图实体类
 *
 * @author Blade
 * @since 2021-03-22
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "FeedOutgoingVO对象", description = "FeedOutgoingVO对象")
public class FeedOutgoingVO extends FeedOutgoing {
	private static final long serialVersionUID = 1L;
	@JsonSerialize(using = ToStringSerializer.class)
	private Long id;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate starttime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate endtime;

}
