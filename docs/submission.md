# 最终提交索引

小组仓库地址：https://github.com/lsy060214/iot-repair-group13

选定语言：Java

| 角色 | 姓名 | 学号 | GitHub 用户名 | 任务 Issue | 主要 PR | 评审记录 |
| --- | --- | --- | --- | --- | --- | --- |
| A 组长 | 冷文品 | 23030913 | 060214lsy | [#1](https://github.com/lsy060214/iot-repair-group13/issues/1) | [#4](https://github.com/lsy060214/iot-repair-group13/pull/4) | [#5](https://github.com/lsy060214/iot-repair-group13/pull/5) 中 A 的评审意见 |
| B | 桂乐乐 | 23030909 | amen340 | [#2](https://github.com/lsy060214/iot-repair-group13/issues/2) | [#5](https://github.com/lsy060214/iot-repair-group13/pull/5) | [#6](https://github.com/lsy060214/iot-repair-group13/pull/6) 中 B 的评审意见 |
| C | 黄钰 | 23030911 | Hy-ai133333 | [#3](https://github.com/lsy060214/iot-repair-group13/issues/3) | [#6](https://github.com/lsy060214/iot-repair-group13/pull/6) | [#4](https://github.com/lsy060214/iot-repair-group13/pull/4) 中 C 的评审意见 |

分支与合并顺序：docs/requirements-a（A）→ docs/models-b（B）→ feat/status-c（C），三个成果 PR 均以 main 为目标分支，按 A→B→C 顺序合并，合并提交依次为 60f4cb5（#4）、4bc90bc（#5）、05af6b9（#6）。本索引经 PR #7 并入 main，其后补记了各次合并提交号。

## 最终复核

main 分支上的 `src/java/StatusRule.java` 为 639 字节，与本地验证过的文件一致；`src/java/StatusRuleTest.java` 为 1107 字节，与起始包一致，测试代码未改动。本机用 JDK 13 重新编译运行，结果为 T01–T04 全部 PASS、Summary: 4/4 passed、退出码 0，输出已记入 docs/test-results.md。

## 个人简短总结

A（冷文品）：负责需求文档、用例图与用例说明、README、仓库初始化与提交索引；评审 B 的模型 PR 时指出类图 status 属性应注明取值来源。

B（桂乐乐）：负责 models.md 的状态图与类图，状态图只保留两条允许转换；评审 C 的代码 PR 时建议补充退出码说明。

C（黄钰）：负责 StatusRule.java 与 test-results.md，按白名单写法实现两条允许规则并保留起始 2/4 与完成 4/4 两份原始输出；评审 A 的需求 PR 时建议 README 补运行命令。

## 说明

仓库由组长账号创建，网页上的初始化、上传、Issue、PR 与合并操作由组长代为执行；桂乐乐（amen340）已接受邀请成为协作者，黄钰（Hy-ai133333）的协作邀请已发出、待对方登录接受；评审意见按各自身份撰写并记录在对应 PR 中，各自登录账号后可复核确认。

## 验收清单

- [x] 3 条功能需求完整
- [x] 3 种图齐全且源材料可编辑
- [x] 一种语言的状态函数与 4 项测试
- [x] 三人均有实际提交和同伴评审
- [x] 三个主要 PR 均已合并
- [x] 两位组员已邀请为协作者（amen340 已接受；Hy-ai133333 待对方接受）
- [ ] 教师账号已加入仓库（待指导教师提供 GitHub 用户名后补充）
