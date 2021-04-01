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
package org.springblade.modules.wens.controller;

import io.swagger.annotations.Api;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import javax.validation.Valid;

import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.springblade.modules.wens.entity.FeedCar;
import org.springblade.modules.wens.vo.FeedCarVO;
import org.springblade.modules.wens.service.IFeedCarService;
import org.springblade.core.boot.ctrl.BladeController;

/**
 *  控制器
 *
 * @author Blade
 * @since 2021-03-29
 */
@RestController
@AllArgsConstructor
@RequestMapping("blade-feed/feedcar")
@Api(value = "", tags = "接口")
public class FeedCarController extends BladeController {

	private IFeedCarService feedCarService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入feedCar")
	public R<FeedCar> detail(FeedCar feedCar) {
		FeedCar detail = feedCarService.getOne(Condition.getQueryWrapper(feedCar));
		return R.data(detail);
	}

	/**
	 * 分页 
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入feedCar")
	public R<IPage<FeedCar>> list(FeedCar feedCar, Query query) {
		IPage<FeedCar> pages = feedCarService.page(Condition.getPage(query), Condition.getQueryWrapper(feedCar));
		return R.data(pages);
	}

	/**
	 * 自定义分页 
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入feedCar")
	public R<IPage<FeedCarVO>> page(FeedCarVO feedCar, Query query) {
		IPage<FeedCarVO> pages = feedCarService.selectFeedCarPage(Condition.getPage(query), feedCar);
		return R.data(pages);
	}

	/**
	 * 新增 
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入feedCar")
	public R save(@Valid @RequestBody FeedCar feedCar) {
		return R.status(feedCarService.save(feedCar));
	}

	/**
	 * 修改 
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入feedCar")
	public R update(@Valid @RequestBody FeedCar feedCar) {
		return R.status(feedCarService.updateById(feedCar));
	}

	/**
	 * 新增或修改 
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入feedCar")
	public R submit(@Valid @RequestBody FeedCar feedCar) {
		return R.status(feedCarService.saveOrUpdate(feedCar));
	}

	
	/**
	 * 删除 
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(feedCarService.removeByIds(Func.toLongList(ids)));
	}

	
}
