# 实际测试记录

语言与版本：Java，JDK 13（`javac 13-ea`、`java version "13-ea" 2019-09-17`），运行于 Windows 本机

测试人员GitHub用户名：Hy-ai133333（黄钰）

运行命令（在 `src/java` 目录下依次执行）：

```
javac StatusRule.java StatusRuleTest.java
java StatusRuleTest
```

| 编号 | 当前状态 | 目标状态 | 预期 | 实际 | 结论 |
| --- | --- | --- | --- | --- | --- |
| T01 | PENDING | PROCESSING | true | true | PASS |
| T02 | PROCESSING | COMPLETED | true | true | PASS |
| T03 | PENDING | COMPLETED | false | false | PASS |
| T04 | COMPLETED | PROCESSING | false | false | PASS |

汇总：`Summary: 4/4 passed`，退出码 0。

## 原始输出

一、起始函数未实现时的真实输出（用于说明起始状态，非最终结果）：

```
T01 FAIL: PENDING -> PROCESSING, expected=true, actual=false
T02 FAIL: PROCESSING -> COMPLETED, expected=true, actual=false
T03 PASS: PENDING -> COMPLETED, expected=false, actual=false
T04 PASS: COMPLETED -> PROCESSING, expected=false, actual=false
Summary: 2/4 passed
```

退出码：1。

二、补齐两条允许规则、重新 `javac` 编译后的真实输出：

```
T01 PASS: PENDING -> PROCESSING, expected=true, actual=true
T02 PASS: PROCESSING -> COMPLETED, expected=true, actual=true
T03 PASS: PENDING -> COMPLETED, expected=false, actual=false
T04 PASS: COMPLETED -> PROCESSING, expected=false, actual=false
Summary: 4/4 passed
```

退出码：0。

三、额外执行的全部 9 种状态组合（非规定的 4 项，用独立的小程序对 `canTransition` 穷举，程序未提交到仓库）：

```
PENDING -> PENDING = false
PENDING -> PROCESSING = true
PENDING -> COMPLETED = false
PROCESSING -> PENDING = false
PROCESSING -> PROCESSING = false
PROCESSING -> COMPLETED = true
COMPLETED -> PENDING = false
COMPLETED -> PROCESSING = false
COMPLETED -> COMPLETED = false
allowed transitions = 2
null -> PROCESSING = false
PENDING -> null = false
```

结果说明：9 种组合中只有 PENDING→PROCESSING 与 PROCESSING→COMPLETED 返回 true，状态不变、跳级、回退均返回 false；传入 null 也不会抛异常，直接返回 false。

## 测试范围

本次规定4项测试（T01–T04）已全部执行并通过。除规定 4 项外，额外执行了上表列出的 9 种状态组合与 2 种 null 输入，未发现与规则不符的结果；仍未覆盖的是“工单不存在”“操作人不是维修人员”等业务层场景，这些不在本实验的函数范围内。

从个人分支下载ZIP复测情况：待 PR 合并前执行并补充（见 `docs/submission.md` 的最终复核一节）。

从main下载ZIP最终复测情况：待三个主要 PR 合并后执行，记录写入 `docs/submission.md`。
