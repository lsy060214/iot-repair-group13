# 最终提交索引

小组仓库地址：https://github.com/lsy060214/iot-repair-group13

选定语言：Java

| 成员 | GitHub 用户名 | 任务 Issue | 主要 PR | 评审记录 |
| --- | --- | --- | --- | --- |
| A（冷文品，组长） | 暂缺（由组长 lsy060214 代为操作） | [#1](https://github.com/lsy060214/iot-repair-group13/issues/1) | [#4](https://github.com/lsy060214/iot-repair-group13/pull/4) | [#5](https://github.com/lsy060214/iot-repair-group13/pull/5) 中 A 的评审意见 |
| B（桂乐乐） | 暂缺 | [#2](https://github.com/lsy060214/iot-repair-group13/issues/2) | [#5](https://github.com/lsy060214/iot-repair-group13/pull/5) | [#6](https://github.com/lsy060214/iot-repair-group13/pull/6) 中 B 的评审意见 |
| C（黄钰） | 暂缺 | [#3](https://github.com/lsy060214/iot-repair-group13/issues/3) | [#6](https://github.com/lsy060214/iot-repair-group13/pull/6) | [#4](https://github.com/lsy060214/iot-repair-group13/pull/4) 中 C 的评审意见 |

分支与合并顺序：docs/requirements-a（A）→ docs/models-b（B）→ feat/status-c（C），三个成果 PR 均以 main 为目标分支，按 A→B→C 顺序合并，合并提交依次为 60f4cb5（#4）、4bc90bc（#5）、05af6b9（#6）。本索引经 PR #7 并入 main，main 当前最新合并提交为 36c3f29。

## 最终复核

main 分支上的 `src/java/StatusRule.java` 为 639 字节，与本地验证过的文件一致；`src/java/StatusRuleTest.java` 为 1107 字节，与起始包一致，测试代码未改动。本机用 JDK 13 重新编译运行，结果为 T01–T04 全部 PASS、Summary: 4/4 passed、退出码 0，输出已记入 docs/test-results.md。

## 个人简短总结

A：负责需求文档、用例图与用例说明、README、仓库初始化与提交索引；评审 B 的模型 PR 时指出类图 status 属性应注明取值来源。

B：负责 models.md 的状态图与类图，状态图只保留两条允许转换；评审 C 的代码 PR 时建议补充退出码说明。

C：负责 StatusRule.java 与 test-results.md，按白名单写法实现两条允许规则并保留起始 2/4 与完成 4/4 两份原始输出；评审 A 的需求 PR 时建议 README 补运行命令。

## 说明

三位组员的 GitHub 账号尚未登记，本仓库的网页操作由组长账号 lsy060214 执行，评审意见按各自角色撰写并记录在上述 PR 中；账号确定后应各自以本人账号重新确认评审，并把用户名补入 README 与上表。

## 验收清单

- [x] 3 条功能需求完整
- [x] 3 种图齐全且源材料可编辑
- [x] 一种语言的状态函数与 4 项测试
- [x] 三人均有实际提交和同伴评审
- [x] 三个主要 PR 均已合并
- [ ] 教师能够访问仓库（需先邀请协作者，用户名待补）
