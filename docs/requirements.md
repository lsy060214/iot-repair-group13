# 需求说明

## 角色与范围

| 角色 | 职责 | 本次涉及的功能 |
| --- | --- | --- |
| 报修人 | 发现设备故障后查看设备信息，选择清单内设备并填写故障描述，提交报修 | FR-01、FR-02 |
| 维修人员（维护人员） | 查看设备信息，开始维修，维修完成后更新工单状态 | FR-01、FR-03 |

范围：只覆盖查看设备信息、提交报修、更新工单状态三项功能。设备数据来自 `data/devices.csv` 模拟清单（DEV-001 温湿度传感器 / A101教室，DEV-002 智能门锁 / B202实验室，DEV-003 烟雾传感器 / C楼走廊），不采集真实传感器数据；不实现登录、数据库、网页、MQTT 与真实硬件接入。

状态名称统一为：待处理 PENDING、处理中 PROCESSING、已完成 COMPLETED。新工单初始状态为 PENDING；本次只有 PENDING→PROCESSING（开始维修）、PROCESSING→COMPLETED（完成维修）两条允许转换，其余一律拒绝。

## FR-01 查看设备信息

角色：报修人、维修人员。

前提：系统已载入模拟设备清单 `data/devices.csv`，清单中至少存在一台设备。

输入：设备编号（例如 DEV-001）；也可不输入编号，直接浏览设备清单。

行为与正常结果：按编号查询时，显示该设备的 deviceId、name、location 三个字段；浏览清单时，按清单顺序列出全部设备的这三项信息。查询只读，不产生工单，不改变任何状态。

异常结果：输入清单中不存在的编号（例如 DEV-999）时，提示“设备编号不存在，请核对后重新输入”，不显示任何设备字段，不创建工单，程序不抛出异常退出。输入为空时按浏览清单处理，不视为错误。

验收方法：查询 DEV-001 应得到“温湿度传感器 / A101教室”；查询 DEV-999 应出现上述提示且不显示设备字段；两种操作都不改变工单数量。

## FR-02 提交报修

角色：报修人。

前提与输入：设备已列入模拟清单（即 FR-01 能查到该编号）；报修人选定该设备，并填写故障描述，描述去掉首尾空格后长度不小于 1。

正常结果：生成一张工单，字段为 orderId（系统按提交顺序生成）、deviceId（所选设备编号）、description（故障描述原文）、status（固定为 PENDING）；工单与设备建立关联，一台设备可对应 0 到多张工单，每张工单只对应 1 台设备。

异常结果：① 未选择设备即提交，提示“请选择报修设备”，不创建工单；② 故障描述为空或仅含空格，提示“请填写故障描述”，不创建工单；③ 设备编号不在清单内，提示设备编号不存在，不创建工单。三种异常下工单总数保持不变。

验收方法：对 DEV-001 提交“传感器没有读数”，应得到 1 张工单，deviceId=DEV-001、description 与输入一致、status=PENDING；再对 DEV-001 提交只含空格的描述，应无新增工单并出现提示，工单总数与提交前一致。

## FR-03 更新工单状态

角色：维修人员。

前提：工单存在，且当前状态为 PENDING 或 PROCESSING。

输入：工单编号、目标状态（PROCESSING 或 COMPLETED），以及对应操作事件（开始维修 / 完成维修）。

允许的转换：PENDING --开始维修--> PROCESSING；PROCESSING --完成维修--> COMPLETED。

拒绝的转换：PENDING→COMPLETED（跳过处理中）、COMPLETED→PROCESSING（已完成后回退）、COMPLETED→COMPLETED、PROCESSING→PROCESSING、PENDING→PENDING（状态不变），以及 COMPLETED→PENDING、PROCESSING→PENDING 和其他任何未列出的组合，全部返回拒绝。

正常与异常结果：转换被允许时，工单状态更新为目标状态并记录本次变更时间，返回成功；转换被拒绝时，工单状态保持原值，返回拒绝原因“不允许从当前状态转换到目标状态”，不发生部分更新。本次“已完成”为业务终态，不提供重新打开、撤销或取消工单。

验收方法：按 T01 PENDING→PROCESSING（true）、T02 PROCESSING→COMPLETED（true）、T03 PENDING→COMPLETED（false）、T04 COMPLETED→PROCESSING（false）调用状态判断函数 `canTransition`，四项结果与预期一致；可另用 PENDING→PENDING 验证同状态转换同样被拒绝。

## 已确认的实验规则

新工单为PENDING，仅允许PENDING转PROCESSING、PROCESSING转COMPLETED。
其他转换一律拒绝。本实验暂不实现完整报修系统，只实现状态判断函数。
