# 校园物联网设备报修实验

组号：第13组（23物联网一班）

成员A：冷文品，学号 23030913，GitHub 用户名 060214lsy

成员B：桂乐乐，学号 23030909，GitHub 用户名 amen340

成员C：黄钰，学号 23030911，GitHub 用户名 Hy-ai133333

本组选定语言：Java。只提交 `src/java` 下的 `StatusRule.java` 与 `StatusRuleTest.java`，`src/python` 为起始包示例，本组不作为完成版。

## 范围
只分析查看设备、提交报修、更新状态。只编程实现状态判断函数。
不接入真实硬件，不实现数据库、网页、登录或MQTT。

## 固定规则
新工单为PENDING。仅允许PENDING转PROCESSING、PROCESSING转COMPLETED。
其他转换一律拒绝，包括状态不变。

| 中文状态 | 程序取值 |
| --- | --- |
| 待处理 | PENDING |
| 处理中 | PROCESSING |
| 已完成 | COMPLETED（本次业务终态） |

## 分工
A（冷文品）完成 `docs/requirements.md`、`docs/usecase.md` 及用例图文件，并负责建仓初始化、组织合并与 `docs/submission.md`。
B（桂乐乐）完成 `docs/models.md` 中的状态图与简单类图。
C（黄钰）完成 `src/java/StatusRule.java` 与 `docs/test-results.md`。
图文件放 `docs/assets`，保留可编辑源材料。
三个主要PR合并后，由A从最新main另开 `docs/submission-a` 分支整理 `docs/submission.md`。

## 运行
Java：进入 `src/java`，先执行 `javac StatusRule.java StatusRuleTest.java`，再执行 `java StatusRuleTest`。
起始函数尚未实现时，预期2项FAIL、2项PASS，`Summary: 2/4 passed`，退出码1。
完成函数后，规定4项测试全部PASS，`Summary: 4/4 passed`，退出码0。
不要修改测试预期来获得通过，也不提交 `.class`、IDE缓存或整个工程目录。
本组不采用Python完成版，`src/python` 保留起始包原样，便于对照。

## 协作
每人一个个人分支和主要PR，交叉评审后合入main。
分支：A=`docs/requirements-a`，B=`docs/models-b`，C=`feat/status-c`，收尾A=`docs/submission-a`。
初始化之外不直接写main。评审顺序：A评审B的PR，B评审C的PR，C评审A的PR。
操作详见配套GitHub教程。
