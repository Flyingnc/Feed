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
import org.springblade.modules.wens.entity.FeedOutgoing;
import org.springblade.modules.wens.vo.FeedOutgoingVO;
import org.springblade.modules.wens.service.IFeedOutgoingService;
import org.springblade.core.boot.ctrl.BladeController;

import java.time.LocalDate;

/**
 *  控制器
 *
 * @author Blade
 * @since 2021-03-22
 */
@RestController
@AllArgsConstructor
@RequestMapping("/blade-feed/feedoutgoing")
@Api(value = "", tags = "接口")
public class FeedOutgoingController extends BladeController {

	private IFeedOutgoingService feedOutgoingService;

	/**
	 * 详情
	 */
	@GetMapping("/detail")
	@ApiOperationSupport(order = 1)
	@ApiOperation(value = "详情", notes = "传入feedOutgoing")
	public R<FeedOutgoing> detail(FeedOutgoing feedOutgoing) {
		FeedOutgoing detail = feedOutgoingService.getOne(Condition.getQueryWrapper(feedOutgoing));
		return R.data(detail);
	}

	/**
	 * 分页
	 */
	@GetMapping("/list")
	@ApiOperationSupport(order = 2)
	@ApiOperation(value = "分页", notes = "传入feedOutgoing")
	public R<IPage<FeedOutgoingVO>> list(FeedOutgoingVO feedOutgoing, Query query) {
		System.out.println("111111111");
		if (feedOutgoing.getEndtime() == null) {
			feedOutgoing.setEndtime(LocalDate.now().plusDays(1));
		}else {
			feedOutgoing.setEndtime(feedOutgoing.getEndtime().plusDays(1));
		}

		if (feedOutgoing.getStarttime() == null) {
			feedOutgoing.setStarttime(LocalDate.now());
		}
		IPage<FeedOutgoingVO> pages = feedOutgoingService.selectFeedOutgoingPage(Condition.getPage(query),feedOutgoing );
		return R.data(pages);
	}

	/**
	 * 自定义分页
	 */
	@GetMapping("/page")
	@ApiOperationSupport(order = 3)
	@ApiOperation(value = "分页", notes = "传入feedOutgoing")
	public R<IPage<FeedOutgoingVO>> page(FeedOutgoingVO feedOutgoing, Query query) {
		IPage<FeedOutgoingVO> pages = feedOutgoingService.selectFeedOutgoingPage(Condition.getPage(query), feedOutgoing);
		return R.data(pages);
	}

	/**
	 * 新增
	 */
	@PostMapping("/save")
	@ApiOperationSupport(order = 4)
	@ApiOperation(value = "新增", notes = "传入feedOutgoing")
	public R save(@Valid @RequestBody FeedOutgoing feedOutgoing) {
		return R.status(feedOutgoingService.save(feedOutgoing));
	}

	/**
	 * 修改
	 */
	@PostMapping("/update")
	@ApiOperationSupport(order = 5)
	@ApiOperation(value = "修改", notes = "传入feedOutgoing")
	public R update(@Valid @RequestBody FeedOutgoing feedOutgoing) {
		return R.status(feedOutgoingService.updateById(feedOutgoing));
	}

	/**
	 * 新增或修改
	 */
	@PostMapping("/submit")
	@ApiOperationSupport(order = 6)
	@ApiOperation(value = "新增或修改", notes = "传入feedOutgoing")
	public R submit(@Valid @RequestBody FeedOutgoing feedOutgoing) {
		return R.status(feedOutgoingService.saveOrUpdate(feedOutgoing));
	}


	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ApiOperationSupport(order = 8)
	@ApiOperation(value = "删除", notes = "传入ids")
	public R remove(@ApiParam(value = "主键集合", required = true) @RequestParam String ids) {
		return R.status(feedOutgoingService.removeByIds(Func.toLongList(ids)));
	}

	/**
	 * 修改状态
	 */
	@PostMapping("/updatestatus")
	@ApiOperationSupport(order = 9)
	@ApiOperation(value = "修改状态", notes = "传入feedOutgoing")
	public R updatestatus(@Valid @RequestBody FeedOutgoing feedOutgoing) {
		feedOutgoing.setStatus(1);
		return R.status(feedOutgoingService.updateById(feedOutgoing));
	}
}
