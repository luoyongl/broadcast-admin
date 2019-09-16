/*
 Navicat Premium Data Transfer

 Source Server         : 11
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : 10.177.3.143:3306
 Source Schema         : broadcast_admin

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 17/07/2019 18:00:35
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b_alarm_record
-- ----------------------------
DROP TABLE IF EXISTS `b_alarm_record`;
CREATE TABLE `b_alarm_record`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_alarm_type` tinyint(4) NULL DEFAULT NULL COMMENT '告警类型',
  `f_alarm_value` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '告警值',
  `f_alarm_desc` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '告警描述',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '告警记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_alarm_record
-- ----------------------------
INSERT INTO `b_alarm_record` VALUES (1, 2, '91.70', '内存使用率达到91.70%', NULL, '2019-06-21 12:11:30', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for b_audio_data
-- ----------------------------
DROP TABLE IF EXISTS `b_audio_data`;
CREATE TABLE `b_audio_data`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_audio_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '音频名称',
  `f_audio_size` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `f_audio_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '音频url',
  `f_time` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '时长',
  `f_bit_rate` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '码率',
  `f_sample_rate` decimal(12, 6) NULL DEFAULT NULL COMMENT '采样率',
  `f_remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '音频数据表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_broadcast_area
-- ----------------------------
DROP TABLE IF EXISTS `b_broadcast_area`;
CREATE TABLE `b_broadcast_area`  (
  `f_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_association_type` tinyint(4) UNSIGNED NULL DEFAULT NULL COMMENT '关联类型：枚举(应急广播，日常广播等等)',
  `f_assocaition_primary_key` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '关联主键',
  `f_area_id` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '区域id',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '广播区域表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_broadcast_data
-- ----------------------------
DROP TABLE IF EXISTS `b_broadcast_data`;
CREATE TABLE `b_broadcast_data`  (
  `f_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_broadcast_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '广播名称',
  `f_broadcast_type` tinyint(4) UNSIGNED NULL DEFAULT NULL COMMENT '广播类型：枚举（应急，日常等等）',
  `f_control_device` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '控制设备（设备id）',
  `f_device_resourcecode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '设备广播对应设备id',
  `f_program_pass` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '节目通道',
  `f_message_type` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '消息类型（字典id）',
  `f_volume_control` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '音量控制',
  `f_broadcast_to` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播放去向（字典id以逗号隔开的字符串）',
  `f_pass_select` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '设备通道（字典id）',
  `f_message_level` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '消息级别（字典id）',
  `f_broadcast_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播发区域表关联主键',
  `f_text_content` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文本转语音-文本内容',
  `f_text_url` varchar(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文本转语音-语音url',
  `f_effective_time` datetime(0) NULL DEFAULT NULL COMMENT '有效日期',
  `f_message_source` int(100) NULL DEFAULT NULL COMMENT '消息来源（枚举）',
  `f_message_command_type` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息指令类型',
  `f_broadcast_terminal_count` int(11) NULL DEFAULT 0 COMMENT '播发终端数量：统计用（默认值为0）',
  `f_response_terminal_count` int(11) NULL DEFAULT 0 COMMENT '响应终端数量：统计用（默认值为0）',
  `f_state` tinyint(4) NULL DEFAULT 0 COMMENT '枚举  0:无(预案专用) 1:待审核 2:待播发 3:审核失败。。。',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间(开始时间)',
  `f_end_time` datetime(0) NULL DEFAULT NULL COMMENT '广播结束时间',
  `f_create_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_updtate_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '操作者id',
  `f_delete_flag` tinyint(1) UNSIGNED NULL DEFAULT 0 COMMENT '删除标志',
  `f_begin_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '广播数据表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_broadcast_device
-- ----------------------------
DROP TABLE IF EXISTS `b_broadcast_device`;
CREATE TABLE `b_broadcast_device`  (
  `f_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_broadcast_id` int(11) NULL DEFAULT NULL COMMENT '广播ID',
  `f_is_timing_broadcast` tinyint(1) NULL DEFAULT NULL COMMENT '广播类型（0：非定时  1：定时广播）',
  `f_device_id` int(11) NULL DEFAULT NULL COMMENT '设备ID',
  `f_broadcast_send_time` datetime(0) NULL DEFAULT NULL COMMENT '广播发送时间',
  `f_device_answer_time` datetime(0) NULL DEFAULT NULL COMMENT '设备响应时间',
  `f_answer_time_num` int(11) NULL DEFAULT NULL COMMENT '响应时间毫秒（单位为毫秒）',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '广播设备关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_broadcast_temp
-- ----------------------------
DROP TABLE IF EXISTS `b_broadcast_temp`;
CREATE TABLE `b_broadcast_temp`  (
  `f_broadcast_id` int(11) NOT NULL COMMENT '广播ID',
  `f_timing_broadcast` tinyint(1) NOT NULL COMMENT '是否定时广播（0：否，1：是）',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间'
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '广播待播发临时表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_broadcast_timing
-- ----------------------------
DROP TABLE IF EXISTS `b_broadcast_timing`;
CREATE TABLE `b_broadcast_timing`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_plan_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '计划名',
  `f_message_type` int(11) NULL DEFAULT NULL COMMENT '消息类型',
  `f_volume` int(11) NULL DEFAULT NULL COMMENT '音量',
  `f_message_level` int(11) NULL DEFAULT NULL COMMENT '消息级别 四级（一般）、三级（较大）、二级（重大）、一级（特别重大）',
  `f_drill_category` int(11) NULL DEFAULT NULL COMMENT '演练类别 系统演练、模拟演练、实际演练、日常广播',
  `f_audio_file` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '音频文件id',
  `f_frequent_audio` int(11) NULL DEFAULT NULL COMMENT '常用音频',
  `f_broadcast_area` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播发区域',
  `f_start_date` date NULL DEFAULT NULL COMMENT '开始日期',
  `f_end_date` date NULL DEFAULT NULL COMMENT '结束日期',
  `f_choose_week` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '选择星期几,可多选',
  `f_start_time` time(0) NULL DEFAULT NULL COMMENT '开始时间',
  `f_end_time` time(0) NULL DEFAULT NULL COMMENT '结束时间',
  `f_time_interval` int(20) NULL DEFAULT NULL COMMENT '时间间隔(s)',
  `f_single_broadcast_time` datetime(0) NULL DEFAULT NULL COMMENT '单次播发时间',
  `f_repeate_time` int(5) NULL DEFAULT NULL COMMENT '重复次数',
  `f_control_device` int(11) NULL DEFAULT NULL COMMENT '控制设备id',
  `f_device_channel` int(11) NULL DEFAULT NULL COMMENT '设备通道',
  `f_broadcast_to` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播发去向',
  `f_message_source` int(100) NULL DEFAULT NULL COMMENT '消息来源(枚举)',
  `f_last_broadcast_time` datetime(0) NULL DEFAULT NULL COMMENT '上次播发时间',
  `f_broadcasted_times` int(11) NULL DEFAULT NULL COMMENT '已播发次数',
  `f_review_flag` tinyint(4) NULL DEFAULT NULL COMMENT '审核状态',
  `f_sort` tinyint(4) NULL DEFAULT NULL COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_create_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  `f_begin_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '广播定时表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_callandsms_record
-- ----------------------------
DROP TABLE IF EXISTS `b_callandsms_record`;
CREATE TABLE `b_callandsms_record`  (
  `f_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_telephone_number` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电话号码',
  `f_control_device` int(11) NULL DEFAULT NULL COMMENT '设备id',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所有者姓名',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `f_creator_id` int(10) NULL DEFAULT NULL COMMENT '创建者id',
  `f_operator_id` int(10) NULL DEFAULT NULL COMMENT '操作者id',
  `f_area` int(10) NULL DEFAULT NULL COMMENT '所属区域',
  `f_call_time` int(5) NULL DEFAULT NULL COMMENT '通话时长',
  `f_telephone_type` tinyint(4) NULL DEFAULT NULL COMMENT '枚举（电话/短信）',
  `f_sms_content` varchar(3000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '短信内容',
  `f_audio_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话音频url',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '通话，短信记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_certificates
-- ----------------------------
DROP TABLE IF EXISTS `b_certificates`;
CREATE TABLE `b_certificates`  (
  `f_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_device_id` int(10) NULL DEFAULT NULL COMMENT '设备名称',
  `f_certificates_number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '证书编号',
  `f_start_date_of_validity` date NULL DEFAULT NULL COMMENT '证书有效起始日期',
  `f_end_date_of_validity` date NULL DEFAULT NULL COMMENT '证书有效结束日期',
  `f_private_key` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '私钥',
  `f_public_key` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公钥',
  `f_remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '证书表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_device_config
-- ----------------------------
DROP TABLE IF EXISTS `b_device_config`;
CREATE TABLE `b_device_config`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_device_id` int(11) NULL DEFAULT NULL COMMENT '设备id',
  `f_fm_receive_rate` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调频接收频率',
  `f_tv_mode` tinyint(255) NULL DEFAULT NULL COMMENT '数字电视射频模式(0:DTMB\r\n1:DVB-C)',
  `f_tv_frequency` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数字电视射频频率',
  `f_qam_method` tinyint(4) NULL DEFAULT NULL COMMENT 'QAM调制方式0: 16QAM;\r\n1: 32QAM;\r\n2: 64QAM;\r\n3: 128QAM;\r\n4: 256QAM\r\n',
  `f_default_volume` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '默认音量',
  `f_broadcast_timeout` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '广播超时时间',
  `f_data_backhaulip_address1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据回传IP地址1',
  `f_data_backhaulip_port1` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据回传IP端口1',
  `f_audio_backhaul_address1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '音频回传地址1',
  `f_audio_backhaul_port1` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '音频回传端口1',
  `f_data_backhaulip_address2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据回传IP地址2',
  `f_data_backhaulip_port2` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '数据回传IP端口2',
  `f_audio_backhaul_address2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '音频回传地址2',
  `f_audio_backhaul_port2` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '音频回传端口2',
  `f_logicalarea_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '逻辑区域码',
  `f_network_mode` tinyint(1) NULL DEFAULT NULL COMMENT '网络模式1：局域网\r\n2：跨路由\r\n',
  `f_ip_address` tinyint(1) NULL DEFAULT NULL COMMENT '本机IP地址',
  `f_mask` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '子网掩码',
  `f_default_gateway` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '网关',
  `f_audio_callback_protocol` tinyint(4) NULL DEFAULT NULL COMMENT '音频回传协议1 UDP;2 TCP;3串口;其它值预留',
  `f_terminal_server_handshake` tinyint(4) NULL DEFAULT NULL COMMENT '终端和服务器握手值为1时表示终端发送握手请求包，值为2时表示服务器握手应签包。',
  `f_audio_callback_Trigger` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '音频回传触发',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_device_config
-- ----------------------------
INSERT INTO `b_device_config` VALUES (1, 400, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for b_device_info
-- ----------------------------
DROP TABLE IF EXISTS `b_device_info`;
CREATE TABLE `b_device_info`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_device_type` tinyint(4) NULL DEFAULT NULL COMMENT '设备类型 枚举（1:前端，2:终端，3:监控，4:摄像头等等）',
  `f_device_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备名称',
  `f_device_resource_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备资源码',
  `f_device_state` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备状态(广播,在线,离线,停电,故障)',
  `f_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备编号',
  `f_device_image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备图片',
  `f_device_ip` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备ip',
  `f_device_port` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备端口',
  `f_device_model` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备型号',
  `f_physical_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物理码',
  `f_location` int(11) NULL DEFAULT NULL COMMENT '所属区域',
  `f_install_address` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '安装地址',
  `f_longitude` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `f_dimension` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维度',
  `f_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `f_enable_state` tinyint(1) NULL DEFAULT NULL COMMENT '启用状态(启用,停用)',
  `f_device_band` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备频段',
  `f_accept_command_pid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收指令pid',
  `f_display_level` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '展示级别',
  `f_remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `f_certificate` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '绑定证书',
  `f_scheme_type` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方案类型',
  `f_maintainer` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '维护人员',
  `f_protocol_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '协议类型',
  `f_manufacturer_info` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '厂商信息',
  `f_nvr` int(11) NULL DEFAULT NULL COMMENT '绑定nvr',
  `f_channel_model` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通道型号',
  `f_login_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录名',
  `f_login_password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录密码',
  `f_channel_content` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备通道(字典表id)',
  `f_channel_number` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通道编号',
  `f_hardware_version` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '硬件版本',
  `f_software_version` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '软件版本',
  `f_power` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功率',
  `f_voltage` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电压',
  `f_rf_level` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '射频电平',
  `f_res_coding` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注（资源编码23字符）',
  `f_res_type_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源类型码(“0314”)',
  `f_res_type_sequence_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源类型顺序码(01)',
  `f_res_subtype_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源子类型码(适配器=02，音柱=04)',
  `f_res_subtype_sequence_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源子类型顺序码（01）',
  `f_support_ip_flag` tinyint(1) NULL DEFAULT NULL COMMENT '是否支持IP',
  `f_support_rds_flag` tinyint(1) NULL DEFAULT NULL COMMENT '是否支持RDS',
  `f_support_dtmb_ts_flag` tinyint(1) NULL DEFAULT NULL COMMENT '是否支持DTMB-TS',
  `f_support_dvbc_ts_flag` tinyint(1) NULL DEFAULT NULL COMMENT '是否支持DVBC-TS',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  `f_back_time` datetime(0) NULL DEFAULT NULL COMMENT '回传时间',
  `f_logic_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '逻辑码',
  `f_back_mode` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回传模式',
  `f_network_mode` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '网路模式',
  `f_power_current` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '功放电流',
  `f_broadcast_state` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '广播状态',
  `f_device_volume` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备音量',
  `f_digital_television_radio_mode` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数字电视射频模式',
  `f_digital_television_radio_rate` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数字电视射频频率',
  `f_qma` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'QAM方式',
  `f_digital_television_signal_quality` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数字电视信号质量',
  `f_signal_rate_list` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调频信号接受频率列表',
  `f_signal_strength_list` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调频信号强度',
  `f_digital_television_signal_strength` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '数字电视信号强度',
  `f_code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编号， 01代表可以听广播的适配器和音柱',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备总表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_device_parameter_set
-- ----------------------------
DROP TABLE IF EXISTS `b_device_parameter_set`;
CREATE TABLE `b_device_parameter_set`  (
  `f_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_device_resource_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备资源编码',
  `f_address_setting_cmd` tinyint(1) NULL DEFAULT 0 COMMENT '区域码设置',
  `f_physical_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物理地址',
  `f_logic_ddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '终端逻辑编码地址',
  `f_workmode_setting_cmd` tinyint(1) NULL DEFAULT 0 COMMENT '工作模式设置',
  `f_workmode` tinyint(4) NULL DEFAULT 3 COMMENT '1:主机全断电 2：待机 3：应急唤醒  4~9：保留',
  `f_freq_setting_cmd` tinyint(1) NULL DEFAULT 0 COMMENT '锁定频率设置',
  `f_dtmb_or_dvbc` tinyint(1) NULL DEFAULT 0 COMMENT '是否需要发送dvb-c和dtmb指令',
  `f_dtmb` tinyint(1) NULL DEFAULT 0 COMMENT '是否选中dtmb',
  `f_dtmb_freq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dtmb频率',
  `f_dtmb_symbolrate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dtmb符号率',
  `f_dtmb_qam` tinyint(5) NULL DEFAULT NULL COMMENT 'dtmb调制方式',
  `f_dvbc` tinyint(1) NULL DEFAULT 0 COMMENT '是否选中dvb-c',
  `f_dvbc_freq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dvb-c频率',
  `f_dvbc_symbolrate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dvb-c符号率',
  `f_dvbc_qam` tinyint(5) NULL DEFAULT NULL COMMENT 'dvb-c调制方式',
  `f_rebacktype_and_address_cmd` tinyint(1) NULL DEFAULT 0 COMMENT '设置回传方式及回传地址',
  `f_reback_type` tinyint(16) NULL DEFAULT NULL COMMENT '回传方式',
  `f_reback_tel_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回传电话号码   reback_type=1时有效，其他值无效，无该字段(采用ASCII字符)',
  `f_reback_IP_address1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址1，reback_type=2时，该字段有效，reback_type为其他值时，无该字段(采用十六进制)',
  `f_reback_IP_address2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址2，reback_type=2时，该字段有效，reback_type为其他值时，无该字段(采用十六进制)',
  `f_reback_IP_port1` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '端口号1，reback_type=2时，该字段有效，reback_type为其他值时，无该字段(采用十六进制)',
  `f_reback_IP_port2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '端口号2，reback_type=2时，该字段有效，reback_type为其他值时，无该字段(采用十六进制)',
  `f_reback_domain_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '域名，reback_type=3时，该字段有效，reback_type为其他值时，无该字段',
  `f_reback_domain_nameport` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '端口号，reback_type=3时，该字段有效，reback_type为其他值时，无该字段',
  `f_column_setting_cmd` tinyint(1) NULL DEFAULT 0 COMMENT '设置音量',
  `f_column` tinyint(3) NULL DEFAULT NULL COMMENT '音量',
  `f_reback_period_setting_cmd` tinyint(1) NULL DEFAULT 0 COMMENT '设置回传周期',
  `f_reback_period` int(10) NULL DEFAULT NULL COMMENT '回传周期统一换算为秒，1天=86400秒',
  `f_rds_setting_cmd` tinyint(1) NULL DEFAULT 0 COMMENT '终端采用RDS传输方式进行设置',
  `f_terminal_rds_set` tinyint(4) NULL DEFAULT NULL COMMENT '终端设备类型 1：应急广播适配器  * 2：收扩机 * 3：音柱  4：应急广播适配器 + 收扩机 + 音柱',
  `f_terminal_rds_data` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'RDS编码指令数据',
  `f_terminal_inspect_setting_cmd` tinyint(1) NULL DEFAULT 0 COMMENT '终端巡检设置',
  `f_terminal_reback_period` int(10) NULL DEFAULT NULL COMMENT '回传周期统一换算为秒，1天=86400秒',
  `f_terminal_reback_type` tinyint(2) NULL DEFAULT NULL COMMENT '终端响应回传方式 1: 收到巡检指令后立刻回传 2：自动周期回传 Terminal_Reback_type',
  `f_terminal_pid_setting_cmd` tinyint(1) NULL DEFAULT 0 COMMENT '终端控制PID设置',
  `f_terminal_pid_set` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '终端支持两个控制PID 1：控制PID设置为0x21 2：控制PID设置为0x22 3~9：保留',
  `f_record_extract_setting_cmd` tinyint(1) NULL DEFAULT 0 COMMENT '录音文件提取',
  `f_record_file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '录音文件名称',
  `f_start_package_num` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开始传输包序号：4字节整型数据',
  `f_audio_reback_mode` tinyint(4) NULL DEFAULT NULL COMMENT '音频回传模式：保留 Audio_reback_mode  1：UDP 2：TCP 3~255',
  `f_audio_reback_serverip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '音频回传ip',
  `f_audio_reback_port` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '音频回传端口，大端模式',
  `f_audio_reback_setting_cmd` tinyint(1) NULL DEFAULT 0 COMMENT '音频实时回传',
  `f_kaiguan` tinyint(1) NULL DEFAULT 1 COMMENT '开关',
  `f_audio_reback_mode_2` tinyint(4) NULL DEFAULT NULL COMMENT '音频回传模式',
  `f_audio_reback_serverip_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '音频回传服务器地址，4字节十六进制IP地址',
  `f_audio_reback_port_2` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '音频回传端口，大端模式',
  `f_operator` int(10) NULL DEFAULT NULL COMMENT '操作者ip',
  `f_operate_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_device_retrun_info
-- ----------------------------
DROP TABLE IF EXISTS `b_device_retrun_info`;
CREATE TABLE `b_device_retrun_info`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_device_id` int(11) NULL DEFAULT NULL COMMENT '设备ID',
  `1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '终端音量',
  `2` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '本地地址',
  `3` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回传地址',
  `4` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '终端资源编码',
  `5` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物理地址编码',
  `6` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '工作状态',
  `7` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '故障代码',
  `8` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备类型',
  `9` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '硬件版本号',
  `10` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '软件版本号',
  `11` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调频信号状态',
  `12` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '有线信号状态',
  `13` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地面无线信号状态',
  `14` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '有线频率',
  `15` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地面无线频率',
  `16` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'FM频点扫描列表',
  `17` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'FM当前频点',
  `18` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'FM维持指令模式',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备总表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_device_return_audio
-- ----------------------------
DROP TABLE IF EXISTS `b_device_return_audio`;
CREATE TABLE `b_device_return_audio`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '录音id',
  `f_audio_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '录音名称',
  `f_device_id` int(11) NULL DEFAULT NULL COMMENT '关联设备',
  `f_audio_url` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '录音文件url',
  `f_use_flag` tinyint(1) NULL DEFAULT NULL COMMENT '是否获取音频',
  `f_audio_byte` longblob NULL COMMENT '回传实时音频流',
  `f_broadcast_id` int(11) NULL DEFAULT NULL COMMENT '广播ID',
  `f_is_timing_broadcast` tinyint(1) NULL DEFAULT 0 COMMENT '是否为定时广播（0：否， 1：是）',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间(回传时间)',
  `f_end_time` datetime(0) NULL DEFAULT NULL COMMENT '回传结束时间',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '音频回传表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_device_state_return
-- ----------------------------
DROP TABLE IF EXISTS `b_device_state_return`;
CREATE TABLE `b_device_state_return`  (
  `f_id` int(10) UNSIGNED NOT NULL COMMENT '主键id',
  `f_device_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `f_fm_receive_rate` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调频接收频率',
  `f_fm_signal_strength` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调频信号强度',
  `f_emergency_broadcast_mes_status` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '应急广播消息状态',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  `f_start_play_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`f_id`) USING BTREE,
  INDEX `f_device_id`(`f_device_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 165 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备状态回传表用于回传更新记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_device_state_return
-- ----------------------------
INSERT INTO `b_device_state_return` VALUES (1, 1, NULL, NULL, NULL, 0, '2019-01-21 17:54:22', NULL, NULL, NULL, 0, '2019-01-22 18:14:39');
INSERT INTO `b_device_state_return` VALUES (2, 3, NULL, NULL, NULL, 0, '2019-01-21 17:54:35', NULL, NULL, NULL, 0, '2019-01-28 04:22:49');
INSERT INTO `b_device_state_return` VALUES (3, 58, NULL, NULL, NULL, 0, '2019-01-21 17:54:56', NULL, NULL, NULL, 0, '2019-01-28 20:15:18');
INSERT INTO `b_device_state_return` VALUES (4, 164, NULL, NULL, NULL, 0, '2019-01-23 19:09:45', NULL, NULL, NULL, 0, '2019-01-23 19:09:53');

-- ----------------------------
-- Table structure for b_device_state_return_history
-- ----------------------------
DROP TABLE IF EXISTS `b_device_state_return_history`;
CREATE TABLE `b_device_state_return_history`  (
  `f_id` int(10) UNSIGNED NOT NULL COMMENT '主键id',
  `f_device_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '设备id',
  `f_start_play_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开播时间',
  `f_broadcast_source` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '广播来源',
  `f_time_range` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '时段',
  `f_broadcast_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '广播类型',
  `f_message_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息类型',
  `f_message_level` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息等级',
  `f_volume` int(11) NULL DEFAULT NULL COMMENT '音量',
  `f_text_message_entity` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '文本消息实体',
  `f_output_type` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '输出类型',
  `f_broadcast_boot_area` varchar(3000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '广播开机区域',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE,
  INDEX `f_device_id`(`f_device_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '设备状态回传历史表用于回传追加记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_dispatch_plan
-- ----------------------------
DROP TABLE IF EXISTS `b_dispatch_plan`;
CREATE TABLE `b_dispatch_plan`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `f_dispach_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `f_describe` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_dispatch_plan
-- ----------------------------
INSERT INTO `b_dispatch_plan` VALUES (1, 'TS调度策略', '所有广播采用TS传输协议进行指令下发，终端接受TS协议并解析完成');
INSERT INTO `b_dispatch_plan` VALUES (2, 'RDS调度策略', '所有广播采用RDS传输协议进行指令下发，终端接受RDS协议并解析');
INSERT INTO `b_dispatch_plan` VALUES (3, 'IP调度策略', '所有广播采用IP传输协议进行指令下发，终端接受IP协议并解析');
INSERT INTO `b_dispatch_plan` VALUES (4, '优先调度策略', '所用广播下发调度指令之前查询终端设备支持协议，查询到后，采用查询到的第一种协议方式下发指令');
INSERT INTO `b_dispatch_plan` VALUES (5, '覆盖调度策略', '调度解析完成后，对所有终端采取发送IP,RDS,TS三种协议方式进行指令传输，发送始终端所有协议指令，仅调度指定的支配源');
INSERT INTO `b_dispatch_plan` VALUES (6, '补点调度策略', '调度解析完成后，对所有终端采取发送IP,RDS,TS三种协议方式进行指令传输，发送始终端所有协议指令。此外，会对此区域的所有适配器发起开机命令，调度覆盖区域内的所有适配器。');

-- ----------------------------
-- Table structure for b_dispatch_plan_copy
-- ----------------------------
DROP TABLE IF EXISTS `b_dispatch_plan_copy`;
CREATE TABLE `b_dispatch_plan_copy`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `f_dispach_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `f_describe` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_dispatch_plan_copy
-- ----------------------------
INSERT INTO `b_dispatch_plan_copy` VALUES (1, 'TS调度策略', '所有广播采用TS传输协议进行指令下发，终端接受TS协议并解析完成');
INSERT INTO `b_dispatch_plan_copy` VALUES (2, 'RDS调度策略', '所有广播采用RDS传输协议进行指令下发，终端接受RDS协议并解析');
INSERT INTO `b_dispatch_plan_copy` VALUES (3, 'IP调度策略', '所有广播采用IP传输协议进行指令下发，终端接受IP协议并解析');
INSERT INTO `b_dispatch_plan_copy` VALUES (4, '优先调度策略', '所用广播下发调度指令之前查询终端设备支持协议，查询到后，采用查询到的第一种协议方式下发指令');
INSERT INTO `b_dispatch_plan_copy` VALUES (5, '覆盖调度策略', '调度解析完成后，对所有终端采取发送IP,RDS,TS三种协议方式进行指令传输，发送始终端所有协议指令，仅调度指定的支配源');
INSERT INTO `b_dispatch_plan_copy` VALUES (6, '补点调度策略', '调度解析完成后，对所有终端采取发送IP,RDS,TS三种协议方式进行指令传输，发送始终端所有协议指令。此外，会对此区域的所有适配器发起开机命令，调度覆盖区域内的所有适配器。');

-- ----------------------------
-- Table structure for b_ebd
-- ----------------------------
DROP TABLE IF EXISTS `b_ebd`;
CREATE TABLE `b_ebd`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `EBD` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '应急广播业务数据',
  `EBD.EBDVersion` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '省级广播记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_ebd_ebm
-- ----------------------------
DROP TABLE IF EXISTS `b_ebd_ebm`;
CREATE TABLE `b_ebd_ebm`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ebd_type` int(1) NULL DEFAULT NULL COMMENT '应急广播业务类型（1：应急广播业务数据 2：应急广播消息 3：消息基本信息 4：应急广播消息内容 5：调用资源信息）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '省级广播记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_ebd_ebm_msg_basic_info
-- ----------------------------
DROP TABLE IF EXISTS `b_ebd_ebm_msg_basic_info`;
CREATE TABLE `b_ebd_ebm_msg_basic_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ebd_type` int(1) NULL DEFAULT NULL COMMENT '应急广播业务类型（1：应急广播业务数据 2：应急广播消息 3：消息基本信息 4：应急广播消息内容 5：调用资源信息）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '省级广播记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_ebd_ebm_msg_content
-- ----------------------------
DROP TABLE IF EXISTS `b_ebd_ebm_msg_content`;
CREATE TABLE `b_ebd_ebm_msg_content`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ebd_type` int(1) NULL DEFAULT NULL COMMENT '应急广播业务类型（1：应急广播业务数据 2：应急广播消息 3：消息基本信息 4：应急广播消息内容 5：调用资源信息）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '省级广播记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_ebd_ebm_msg_dispatch
-- ----------------------------
DROP TABLE IF EXISTS `b_ebd_ebm_msg_dispatch`;
CREATE TABLE `b_ebd_ebm_msg_dispatch`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ebd_type` int(1) NULL DEFAULT NULL COMMENT '应急广播业务类型（1：应急广播业务数据 2：应急广播消息 3：消息基本信息 4：应急广播消息内容 5：调用资源信息）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '省级广播记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_picture_ads
-- ----------------------------
DROP TABLE IF EXISTS `b_picture_ads`;
CREATE TABLE `b_picture_ads`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_image_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片名称',
  `f_address` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '存放地址',
  `f_send_all_dates` tinyint(1) NULL DEFAULT NULL COMMENT '是否发送所有日期',
  `f_send_start_date` date NULL DEFAULT NULL COMMENT '发送开始日期',
  `f_send_end_date` date NULL DEFAULT NULL COMMENT '发送结束日期',
  `f_send_all_times` tinyint(1) NULL DEFAULT NULL COMMENT '是否发送所有时间',
  `f_send_start_time` time(0) NULL DEFAULT NULL COMMENT '发送开始时间',
  `f_send_end_time` time(0) NULL DEFAULT NULL COMMENT '发送结束时间',
  `f_broadcast_area` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播发区域',
  `f_roll_interval` int(11) NULL DEFAULT NULL COMMENT '滚动间隔(s)',
  `f_remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  `f_state` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '发布为1，停止为0',
  `f_device` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '终端设备',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '图片广播表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_picture_ads
-- ----------------------------
INSERT INTO `b_picture_ads` VALUES (52, '安卓证明1', 'http://10.177.3.143:8080/upload/image/d3af35fd-3fb2-4c05-bff3-490a800d3471.png', NULL, '2019-03-23', '2019-03-26', NULL, '11:19:22', '14:19:22', '150,151,155,156,157,158,159', 12, '', 0, '2019-03-23 15:19:31', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (54, '安卓证明31', 'http://10.177.3.143:8080/upload/image/0dd2d763-a8d2-416c-b342-260ee5061918.png', NULL, '2019-03-23', '2019-03-26', NULL, '10:47:14', '17:47:14', '130', 19, '111', 0, '2019-03-23 15:47:48', 1, '2019-03-23 04:22:01', 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (55, '更高的', '', NULL, '2019-04-05', '2019-04-06', NULL, '18:27:29', '20:27:29', '151', 4, '', 0, '2019-04-05 18:27:38', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (56, '上发射', '', NULL, '2019-04-06', '2019-04-07', NULL, '17:18:43', '19:18:43', '151', 4, '', 0, '2019-04-06 15:18:52', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (57, '帆胜丰士', '', NULL, '2019-04-06', '2019-04-07', NULL, '16:19:17', '17:19:17', '151', 5, '发士大夫十分', 0, '2019-04-06 15:19:34', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (58, '方式', '', NULL, '2019-04-06', '2019-04-07', NULL, '16:22:30', '17:22:30', '151', 5, '发士大夫十分', 0, '2019-04-06 15:22:41', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (59, '方式方式', '', NULL, '2019-04-06', '2019-04-07', NULL, '16:23:03', '17:23:03', '151', 5, '发生范德萨发生', 0, '2019-04-06 15:23:12', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (60, '法国德国', '', NULL, '2019-04-06', '2019-04-07', NULL, '16:32:50', '17:34:50', '150,151,155,156,157,158,159', 7, '发生发射点发射点发', 0, '2019-04-06 15:33:01', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (61, 'fdfs', '', NULL, NULL, NULL, NULL, NULL, NULL, '151', 5, NULL, 0, '2019-04-07 19:44:18', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (62, 'trte', '', NULL, NULL, NULL, NULL, NULL, NULL, '151', 4, NULL, 0, '2019-04-07 19:53:47', 1, '2019-04-07 19:54:07', 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (63, 'rtet', '', NULL, '2019-04-07', '2019-04-09', NULL, '20:56:50', '21:56:50', '159', 6, '', 0, '2019-04-07 19:56:58', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (64, 'fsd', '', NULL, NULL, NULL, NULL, NULL, NULL, '130', 5, NULL, 0, '2019-04-08 09:12:27', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (65, '1', '', NULL, NULL, NULL, NULL, NULL, NULL, 'undefined', 5, NULL, 0, '2019-04-08 17:52:44', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_picture_ads` VALUES (66, '测试二', 'http://10.177.3.205:8080/upload/image\\5714f009-9b80-4940-8dc1-3f31bd1b1a9d.png', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 60, NULL, 0, '2019-04-11 20:43:03', 1, '2019-04-11 20:43:49', 1, 0, '0', '终端6;终端7;终端8;终端9;');
INSERT INTO `b_picture_ads` VALUES (67, '测试一', 'http://10.177.3.205:8080/upload/image\\16849d63-faad-44d5-8e8a-c4a2f3cc0b51.png', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 60, NULL, 0, '2019-04-11 20:59:13', 1, '2019-04-12 14:47:56', 1, 0, '0', '终端1,终端2');
INSERT INTO `b_picture_ads` VALUES (68, '测试三', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, 0, '2019-04-12 17:25:23', 1, NULL, NULL, 0, '0', '终端1,终端2,终端3');
INSERT INTO `b_picture_ads` VALUES (69, '22', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 3, NULL, 0, '2019-04-14 12:15:16', 1, NULL, 1, 1, '0', '终端1,终端2');
INSERT INTO `b_picture_ads` VALUES (70, 'a', 'http://10.177.3.143:8080/upload/image/55d828d0-cac5-4f4a-b32a-b0825dd2ae95.jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 5, NULL, 0, '2019-04-18 17:35:08', 1, NULL, NULL, 0, '0', '图文终端');

-- ----------------------------
-- Table structure for b_program_channel
-- ----------------------------
DROP TABLE IF EXISTS `b_program_channel`;
CREATE TABLE `b_program_channel`  (
  `f_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_pass_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '通道号',
  `f_modulation` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '调制方式 二进制数',
  `f_pass_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '通道名称',
  `f_pass_type` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '通道类型（字典id）',
  `f_control_device` int(11) NULL DEFAULT NULL COMMENT '控制设备（设备id）',
  `f_broadcast_area` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播发区域（行政区域id）',
  `f_priority` tinyint(4) UNSIGNED NULL DEFAULT NULL COMMENT '优先级',
  `f_nit_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'NIT ID',
  `f_pcrp_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'PCRPID',
  `f_service_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Service ID',
  `f_ts_id` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'TS ID',
  `f_media_type` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '媒体流类型(字典id)',
  `f_media_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '流媒体URL',
  `f_audio_pid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '音频pid',
  `f_rds_output` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'RDS 输出',
  `f_output_address` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '输出地址',
  `f_output_port` smallint(11) NULL DEFAULT NULL COMMENT '输出端口',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT NULL COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '节目通道' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_regional_features
-- ----------------------------
DROP TABLE IF EXISTS `b_regional_features`;
CREATE TABLE `b_regional_features`  (
  `f_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_main_title` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文本主标题',
  `f_content` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文本主内容',
  `f_rich_text_content` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '富文本内容',
  `f_image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片存放地址',
  `f_subheading_one` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文本副标题一',
  `f_sub_content_one` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文本副内容一',
  `f_subheading_two` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文本副标题二',
  `f_sub_content_two` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文本副内容二',
  `f_subheading_three` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文本副标题三',
  `f_sub_content_three` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文本副内容三',
  `f_image_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '图片类型',
  `f_brief_classification` int(4) NULL DEFAULT NULL COMMENT '简介分类',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '修改者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 328 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '区域特色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_regional_features
-- ----------------------------
INSERT INTO `b_regional_features` VALUES (312, '区域特色222', '区域特色区域特色区域特色', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 2, 0, '2019-03-27 18:01:15', 1, NULL, NULL, 0);
INSERT INTO `b_regional_features` VALUES (313, '区域特色', '区域特色区域特色区域特色', NULL, NULL, '区域特色', '区域特色v区域特色区域特色', '区域特色', '区域特色区域特色', '区域特色区域特色', '区域特色区域特色', NULL, 3, 0, '2019-03-26 18:29:26', 1, NULL, NULL, 0);
INSERT INTO `b_regional_features` VALUES (317, NULL, '广西特色', NULL, 'http://10.177.3.143:8080/upload/image/a626d7e2-31a1-40d2-be4c-613062fa737b.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'jpg', 4, 0, '2019-03-20 17:16:16', 1, NULL, NULL, 0);
INSERT INTO `b_regional_features` VALUES (318, NULL, '左州特色', NULL, 'http://10.177.3.143:8080/upload/image/a58f9964-57d9-4636-a07e-125a77dbcc30.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'jpg', 4, 0, '2019-03-20 17:16:36', 1, NULL, NULL, 0);
INSERT INTO `b_regional_features` VALUES (319, NULL, '南宁特色', NULL, 'http://10.177.3.143:8080/upload/image/276f827b-55f0-4bda-ab79-445f7507477c.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'jpg', 4, 0, '2019-03-20 17:16:54', 1, NULL, NULL, 0);
INSERT INTO `b_regional_features` VALUES (323, '区域特色', '区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域特色区域', NULL, 'http://10.177.3.205:8080/upload/image/9eaf0dfd-d364-42fd-9768-ac1879648d3f.jpg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1, 0, '2019-03-28 16:36:56', 1, NULL, NULL, 0);
INSERT INTO `b_regional_features` VALUES (324, NULL, '桂林特色', NULL, 'http://10.177.3.205:8080/upload/image\\ec83181b-a574-4400-9f3f-0c855a7797cc.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 'jpg', 4, 0, '2019-04-05 11:23:27', 1, '2019-04-05 11:23:41', 1, 1);
INSERT INTO `b_regional_features` VALUES (325, NULL, 'gdfg', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, 'jpg', 4, 0, '2019-04-07 20:15:09', 1, '2019-04-08 17:28:46', 1, 1);
INSERT INTO `b_regional_features` VALUES (326, NULL, '桂林特色', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, 'jpg', 4, 0, '2019-04-08 16:53:58', 1, '2019-04-08 17:28:46', 1, 1);
INSERT INTO `b_regional_features` VALUES (327, NULL, '桂林杉树', NULL, '', NULL, NULL, NULL, NULL, NULL, NULL, 'jpg', 4, 0, '2019-04-08 17:29:00', 1, '2019-04-08 17:49:26', 1, 1);

-- ----------------------------
-- Table structure for b_review
-- ----------------------------
DROP TABLE IF EXISTS `b_review`;
CREATE TABLE `b_review`  (
  `f_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_big_classification` tinyint(4) NULL DEFAULT NULL COMMENT '审核大分类',
  `f_review_type` tinyint(4) NULL DEFAULT NULL COMMENT '审核类型 枚举（日常广播，定时广播等）',
  `f_review_object_id` int(11) NULL DEFAULT NULL COMMENT '审核对象id',
  `f_review_result` tinyint(4) NULL DEFAULT 1 COMMENT '0:待审核 1：审核失败 2：审核通过',
  `f_review_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `f_reviewer` int(11) NULL DEFAULT NULL COMMENT '审核人',
  `f_remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '审核表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_rolling_subtitles
-- ----------------------------
DROP TABLE IF EXISTS `b_rolling_subtitles`;
CREATE TABLE `b_rolling_subtitles`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_title` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',
  `f_address` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `f_start_date` date NULL DEFAULT NULL COMMENT '开始日期',
  `f_end_date` date NULL DEFAULT NULL COMMENT '结束日期',
  `f_start_time` time(0) NULL DEFAULT NULL COMMENT '开始时间',
  `f_end_time` time(0) NULL DEFAULT NULL COMMENT '结束时间',
  `f_broadcast_area` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播发区域',
  `f_remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  `f_state` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '发布为1，停止为0',
  `f_device` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '终端设备',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 132 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '滚动字幕表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_rolling_subtitles
-- ----------------------------
INSERT INTO `b_rolling_subtitles` VALUES (86, '测试字幕', 'http://10.177.3.143:8080/upload/other/3d0c251f-1c2a-4402-81b7-5a3b657ae92e.txt', '2019-03-23', '2019-03-25', '16:13:13', '18:13:13', '160,162,163,164,165,166,167,168,169,170,171', '111', 0, '2019-03-23 16:13:22', 1, '2019-03-23 04:13:37', 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (87, '测试字幕1', '', '2019-03-23', '2019-03-25', '16:13:55', '17:13:55', '160,162,163,164,165,166,167,168,169,170,171', '111', 0, '2019-03-23 16:14:05', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (88, '测试字幕2', '', '2019-03-23', '2019-03-28', '16:15:22', '23:15:22', '160,162,163,164,165,166,167,168,169,170,171', '111', 0, '2019-03-23 16:15:31', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (89, '测试', '', '2019-04-05', '2019-04-06', '19:25:52', '21:25:52', '151', '', 0, '2019-04-05 18:26:12', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (90, '测试', '', '2019-04-05', '2019-04-06', '19:25:52', '21:25:52', '151', '', 0, '2019-04-05 18:26:12', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (91, '方式', '', '2019-04-05', '2019-04-06', '20:26:42', '23:26:42', '151', '', 0, '2019-04-05 18:26:48', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (92, '高度', '', '2019-04-05', '2019-04-06', '18:28:49', '20:28:49', '151', '', 0, '2019-04-05 18:28:54', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (93, '广泛', '', '2019-04-05', '2019-04-06', '20:29:14', '22:29:14', '151', '', 0, '2019-04-05 18:29:20', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (94, '会突然', '', '2019-04-06', '2019-04-07', '13:35:54', '16:35:54', '151', '', 0, '2019-04-06 11:36:10', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (95, '发的', '', '2019-04-06', '2019-04-07', '14:49:46', '17:49:46', '151', '', 0, '2019-04-06 11:52:32', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (96, '二分', '', '2019-04-06', '2019-04-07', '17:04:12', '20:04:12', '151', '', 0, '2019-04-06 15:04:19', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (97, '高度高度', '', '2019-04-06', '2019-04-07', '17:05:20', '19:05:20', '151', '给法国发过法规的规定', 0, '2019-04-06 15:05:28', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (98, '感到各地纷纷', '', '2019-04-06', '2019-04-07', '16:13:27', '17:13:27', '151', '官方个大概豆腐干', 0, '2019-04-06 15:13:34', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (99, '方式方式方式', '', '2019-04-06', '2019-04-07', '16:23:56', '18:23:56', '151', '发生发射点发生', 0, '2019-04-06 15:24:01', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (100, '法随风郭', '', '2019-04-06', '2019-04-07', '16:24:49', '18:24:49', '151', '的沙发沙发沙发', 0, '2019-04-06 15:24:55', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (101, '发顺丰顺丰', '', '2019-04-06', '2019-04-07', '16:25:58', '18:25:58', '151', '个大概豆腐干的', 0, '2019-04-06 15:26:06', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (102, '豆腐干大概', '', '2019-04-06', '2019-04-07', '16:28:10', '18:28:10', '151', '古典风格的广东', 0, '2019-04-06 15:28:17', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (103, '微软微软', '', '2019-04-06', '2019-04-07', '16:32:26', '17:32:26', '151', '个顶个顶个顶个', 0, '2019-04-06 15:32:31', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (104, 'fdfsfs,fsdfsfs', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-07 17:10:03', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (105, 'gdfdgd,dfgdgg', NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-07 17:12:09', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (106, 'fsd', 'fsf', NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-07 18:08:22', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (107, 'sfsdf', 'fsfs', NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-07 18:08:45', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (108, 'fdsf', 'fsdf', NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-07 18:13:22', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (109, 'gtrterteg', '', NULL, NULL, NULL, NULL, NULL, 'fdsf', 0, '2019-04-07 18:18:38', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (110, '热热特热特', '', NULL, NULL, NULL, NULL, '151', '广泛大概', 0, '2019-04-07 18:21:29', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (111, '防辐射服', '士大夫石帆胜丰', NULL, NULL, NULL, NULL, '151', NULL, 0, '2019-04-07 19:33:29', 1, '2019-04-07 19:40:02', 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (112, '发士大夫十', '的发顺丰到付', NULL, NULL, NULL, NULL, '150,151,155,156,157,158,159', NULL, 0, '2019-04-07 19:41:12', 1, '2019-04-07 19:41:51', 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (113, '1', NULL, NULL, NULL, NULL, NULL, 'undefined', '1', 0, '2019-04-08 16:36:16', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (114, '12121', NULL, NULL, NULL, NULL, NULL, 'undefined', '1', 0, '2019-04-09 20:05:04', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (115, '城南花一开', NULL, NULL, NULL, NULL, NULL, 'undefined', '性感的枪手', 0, '2019-04-11 09:20:41', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (116, '顾北人消瘦', NULL, NULL, NULL, NULL, NULL, 'undefined', '性感的枪手', 0, '2019-04-11 09:21:41', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (117, 'ffgfgfff', NULL, NULL, NULL, NULL, NULL, 'undefined,undefined,undefined,undefined,undefined,undefined,undefined,undefined,undefined', '1212', 0, '2019-04-11 11:05:35', 1, '2019-04-11 11:05:55', 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (118, 'dfffddff', NULL, NULL, NULL, NULL, NULL, 'undefined', 'dfdfdfdf', 0, '2019-04-11 11:33:18', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (119, 'dsfdfddf', NULL, NULL, NULL, NULL, NULL, 'undefined', 'dfdfdfdfdfdd', 0, '2019-04-11 11:39:04', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (120, '12121212', NULL, NULL, NULL, NULL, NULL, 'undefined', '121212', 0, '2019-04-11 11:40:10', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (121, 'gfggfgfhg', NULL, NULL, NULL, NULL, NULL, 'undefined', 'ffgffffg', 0, '2019-04-11 11:45:29', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (122, 'nifdidiid', NULL, NULL, NULL, NULL, NULL, ',', '枪手', 0, '2019-04-11 11:50:49', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (123, 'dfdffgffffggfgfg', NULL, NULL, NULL, NULL, NULL, 'undefined,', 'fffffgfgffffg', 0, '2019-04-11 11:52:26', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (124, 'qwqwwewewe', NULL, NULL, NULL, NULL, NULL, 'undefined,', 'qwqwwewe', 0, '2019-04-11 11:53:38', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (125, 'fdfdf', NULL, NULL, NULL, NULL, NULL, 'undefined,', 'fdfdfdfdf', 0, '2019-04-11 11:54:30', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (126, '22frerre', NULL, NULL, NULL, NULL, NULL, '终端1,', 'ererer', 0, '2019-04-11 11:55:14', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_rolling_subtitles` VALUES (127, 'efgfgg', NULL, NULL, NULL, NULL, NULL, NULL, 'fgfg', 0, '2019-04-11 13:24:24', 1, NULL, 1, 1, '0', '终端1,');
INSERT INTO `b_rolling_subtitles` VALUES (128, '测试一', NULL, NULL, NULL, NULL, NULL, NULL, '测试一', 0, '2019-04-11 13:41:05', 1, NULL, 1, 1, '0', '终端1,');
INSERT INTO `b_rolling_subtitles` VALUES (129, '测试一', NULL, NULL, NULL, NULL, NULL, '终端7;终端8;终端9;', '测试一', 0, '2019-04-11 13:55:45', 1, '2019-04-11 19:46:37', 1, 0, '0', '终端4;终端5;');
INSERT INTO `b_rolling_subtitles` VALUES (130, '测试二', NULL, NULL, NULL, NULL, NULL, NULL, '测试二', 0, '2019-04-11 19:35:16', 1, '2019-04-11 19:45:51', 1, 1, '0', '终端4;终端5;终端8;终端9;');
INSERT INTO `b_rolling_subtitles` VALUES (131, '测试二', NULL, NULL, NULL, NULL, NULL, NULL, '测试二', 0, '2019-04-12 17:19:39', 1, NULL, NULL, 0, '0', '终端1,终端2');

-- ----------------------------
-- Table structure for b_server_runtime_info
-- ----------------------------
DROP TABLE IF EXISTS `b_server_runtime_info`;
CREATE TABLE `b_server_runtime_info`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_server_type` int(2) NULL DEFAULT NULL COMMENT '服务类型（1：调控服务器  2：回传服务器 3：省级平台解析服务器）',
  `f_server_state` int(2) NULL DEFAULT 0 COMMENT '服务器状态（0：离线  1：在线）',
  `f_creat_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '服务器状态表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_server_runtime_info
-- ----------------------------
INSERT INTO `b_server_runtime_info` VALUES (1, 1, 0, '2019-06-17 10:50:51', '2019-06-21 12:11:30');
INSERT INTO `b_server_runtime_info` VALUES (2, 2, 0, '2019-06-17 10:50:51', '2019-06-21 12:11:30');
INSERT INTO `b_server_runtime_info` VALUES (3, 3, 0, '2019-06-17 10:50:51', '2019-06-21 12:11:30');

-- ----------------------------
-- Table structure for b_system_info_record
-- ----------------------------
DROP TABLE IF EXISTS `b_system_info_record`;
CREATE TABLE `b_system_info_record`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_info_type` tinyint(4) NULL DEFAULT NULL COMMENT '记录类型',
  `f_total_value` bigint(20) NULL DEFAULT 0 COMMENT '总大小',
  `f_used_value` bigint(20) NULL DEFAULT 0 COMMENT '已用大小',
  `f_free_value` bigint(20) NULL DEFAULT 0 COMMENT '未用大小',
  `f_percent_used` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '0' COMMENT '已用百分比',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1449 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统信息记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_system_info_record
-- ----------------------------
INSERT INTO `b_system_info_record` VALUES (1, 1, NULL, NULL, NULL, '22.48', NULL, '2019-06-17 10:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (2, 2, 8372408320, 6900436992, 1471971328, '82.42', NULL, '2019-06-17 10:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (3, 1, NULL, NULL, NULL, '24.78', NULL, '2019-06-17 10:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (4, 2, 8372408320, 7010521088, 1361887232, '83.73', NULL, '2019-06-17 10:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (5, 1, NULL, NULL, NULL, '22.55', NULL, '2019-06-17 10:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (6, 2, 8372408320, 7065161728, 1307246592, '84.39', NULL, '2019-06-17 10:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (7, 1, NULL, NULL, NULL, '20.77', NULL, '2019-06-17 10:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (8, 2, 8372408320, 7037186048, 1335222272, '84.05', NULL, '2019-06-17 10:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (9, 1, NULL, NULL, NULL, '27.96', NULL, '2019-06-17 10:44:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (10, 2, 8372408320, 7006322688, 1366085632, '83.68', NULL, '2019-06-17 10:44:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (11, 1, NULL, NULL, NULL, '25.96', NULL, '2019-06-17 10:44:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (12, 2, 8372408320, 7050342400, 1322065920, '84.21', NULL, '2019-06-17 10:44:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (13, 1, NULL, NULL, NULL, '38.36', NULL, '2019-06-17 10:45:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (14, 2, 8372408320, 7050571776, 1321836544, '84.21', NULL, '2019-06-17 10:45:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (15, 1, NULL, NULL, NULL, '20.47', NULL, '2019-06-17 10:45:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (16, 2, 8372408320, 6985498624, 1386909696, '83.43', NULL, '2019-06-17 10:45:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (17, 1, NULL, NULL, NULL, '16.30', NULL, '2019-06-17 10:46:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (18, 2, 8372408320, 7018491904, 1353916416, '83.83', NULL, '2019-06-17 10:46:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (19, 1, NULL, NULL, NULL, '21.35', NULL, '2019-06-17 10:46:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (20, 2, 8372408320, 7043694592, 1328713728, '84.13', NULL, '2019-06-17 10:46:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (21, 1, NULL, NULL, NULL, '21.45', NULL, '2019-06-17 10:47:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (22, 2, 8372408320, 7007997952, 1364410368, '83.70', NULL, '2019-06-17 10:47:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (23, 1, NULL, NULL, NULL, '25.76', NULL, '2019-06-17 10:47:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (24, 2, 8372408320, 6929563648, 1442844672, '82.77', NULL, '2019-06-17 10:47:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (25, 1, NULL, NULL, NULL, '22.61', NULL, '2019-06-17 10:49:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (26, 2, 8372408320, 7165366272, 1207042048, '85.58', NULL, '2019-06-17 10:49:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (27, 1, NULL, NULL, NULL, '31.99', NULL, '2019-06-17 10:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (28, 2, 8372408320, 7004811264, 1367597056, '83.67', NULL, '2019-06-17 10:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (29, 1, NULL, NULL, NULL, '31.91', NULL, '2019-06-17 10:50:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (30, 2, 8372408320, 7078182912, 1294225408, '84.54', NULL, '2019-06-17 10:50:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (31, 1, NULL, NULL, NULL, '32.47', NULL, '2019-06-17 10:51:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (32, 2, 8372408320, 7147307008, 1225101312, '85.37', NULL, '2019-06-17 10:51:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (33, 1, NULL, NULL, NULL, '41.34', NULL, '2019-06-17 10:51:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (34, 2, 8372408320, 7210180608, 1162227712, '86.12', NULL, '2019-06-17 10:51:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (35, 1, NULL, NULL, NULL, '22.69', NULL, '2019-06-17 10:52:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (36, 2, 8372408320, 7197401088, 1175007232, '85.97', NULL, '2019-06-17 10:52:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (37, 1, NULL, NULL, NULL, '39.35', NULL, '2019-06-17 10:52:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (38, 2, 8372408320, 6858809344, 1513598976, '81.92', NULL, '2019-06-17 10:52:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (39, 1, NULL, NULL, NULL, '33.38', NULL, '2019-06-17 10:53:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (40, 2, 8372408320, 6969884672, 1402523648, '83.25', NULL, '2019-06-17 10:53:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (41, 1, NULL, NULL, NULL, '22.67', NULL, '2019-06-17 10:59:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (42, 2, 8372408320, 7049428992, 1322979328, '84.20', NULL, '2019-06-17 10:59:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (43, 1, NULL, NULL, NULL, '32.51', NULL, '2019-06-17 10:59:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (44, 2, 8372408320, 6929891328, 1442516992, '82.77', NULL, '2019-06-17 10:59:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (45, 1, NULL, NULL, NULL, '25.29', NULL, '2019-06-17 11:00:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (46, 2, 8372408320, 6924963840, 1447444480, '82.71', NULL, '2019-06-17 11:00:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (47, 1, NULL, NULL, NULL, '18.22', NULL, '2019-06-17 11:00:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (48, 2, 8372408320, 6931808256, 1440600064, '82.79', NULL, '2019-06-17 11:00:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (49, 1, NULL, NULL, NULL, '40.61', NULL, '2019-06-17 11:01:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (50, 2, 8372408320, 7089639424, 1282768896, '84.68', NULL, '2019-06-17 11:01:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (51, 1, NULL, NULL, NULL, '20.97', NULL, '2019-06-17 11:01:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (52, 2, 8372408320, 7016620032, 1355788288, '83.81', NULL, '2019-06-17 11:01:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (53, 1, NULL, NULL, NULL, '28.08', NULL, '2019-06-17 11:02:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (54, 2, 8372408320, 6898405376, 1474002944, '82.39', NULL, '2019-06-17 11:02:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (55, 1, NULL, NULL, NULL, '21.05', NULL, '2019-06-17 11:02:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (56, 2, 8372408320, 6842830848, 1529577472, '81.73', NULL, '2019-06-17 11:02:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (57, 1, NULL, NULL, NULL, '22.74', NULL, '2019-06-17 11:04:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (58, 2, 8372408320, 6573875200, 1798533120, '78.52', NULL, '2019-06-17 11:04:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (59, 1, NULL, NULL, NULL, '21.00', NULL, '2019-06-17 11:04:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (60, 2, 8372408320, 6530048000, 1842360320, '77.99', NULL, '2019-06-17 11:04:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (61, 1, NULL, NULL, NULL, '16.55', NULL, '2019-06-17 11:05:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (62, 2, 8372408320, 6491283456, 1881124864, '77.53', NULL, '2019-06-17 11:05:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (63, 1, NULL, NULL, NULL, '55.52', NULL, '2019-06-17 11:05:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (64, 2, 8372408320, 6979100672, 1393307648, '83.36', NULL, '2019-06-17 11:05:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (65, 1, NULL, NULL, NULL, '64.34', NULL, '2019-06-17 11:06:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (66, 2, 8372408320, 6762483712, 1609924608, '80.77', NULL, '2019-06-17 11:06:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (67, 1, NULL, NULL, NULL, '48.20', NULL, '2019-06-17 11:06:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (68, 2, 8372408320, 6794407936, 1578000384, '81.15', NULL, '2019-06-17 11:06:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (69, 1, NULL, NULL, NULL, '41.13', NULL, '2019-06-17 11:07:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (70, 2, 8372408320, 6782451712, 1589956608, '81.01', NULL, '2019-06-17 11:07:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (71, 1, NULL, NULL, NULL, '71.93', NULL, '2019-06-17 11:07:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (72, 2, 8372408320, 6122176512, 2250231808, '73.12', NULL, '2019-06-17 11:07:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (73, 1, NULL, NULL, NULL, '47.85', NULL, '2019-06-17 11:08:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (74, 2, 8372408320, 6132051968, 2240356352, '73.24', NULL, '2019-06-17 11:08:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (75, 1, NULL, NULL, NULL, '44.65', NULL, '2019-06-17 11:08:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (76, 2, 8372408320, 6084734976, 2287673344, '72.68', NULL, '2019-06-17 11:08:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (77, 1, NULL, NULL, NULL, '44.39', NULL, '2019-06-17 11:09:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (78, 2, 8372408320, 6049579008, 2322829312, '72.26', NULL, '2019-06-17 11:09:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (79, 1, NULL, NULL, NULL, '21.60', NULL, '2019-06-17 11:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (80, 2, 8372408320, 6021173248, 2351235072, '71.92', NULL, '2019-06-17 11:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (81, 1, NULL, NULL, NULL, '17.53', NULL, '2019-06-17 11:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (82, 2, 8372408320, 5885145088, 2487263232, '70.29', NULL, '2019-06-17 11:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (83, 1, NULL, NULL, NULL, '20.76', NULL, '2019-06-17 11:10:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (84, 2, 8372408320, 5800894464, 2571513856, '69.29', NULL, '2019-06-17 11:10:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (85, 1, NULL, NULL, NULL, '22.54', NULL, '2019-06-17 11:11:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (86, 2, 8372408320, 5749219328, 2623188992, '68.67', NULL, '2019-06-17 11:11:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (87, 1, NULL, NULL, NULL, '16.52', NULL, '2019-06-17 11:11:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (88, 2, 8372408320, 5741236224, 2631172096, '68.57', NULL, '2019-06-17 11:11:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (89, 1, NULL, NULL, NULL, '24.44', NULL, '2019-06-17 11:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (90, 2, 8372408320, 5767090176, 2605318144, '68.88', NULL, '2019-06-17 11:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (91, 1, NULL, NULL, NULL, '18.24', NULL, '2019-06-17 11:12:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (92, 2, 8372408320, 5790322688, 2582085632, '69.16', NULL, '2019-06-17 11:12:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (93, 1, NULL, NULL, NULL, '10.87', NULL, '2019-06-18 14:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (94, 2, 8416260096, 5611606016, 2804654080, '66.68', NULL, '2019-06-18 14:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (95, 1, NULL, NULL, NULL, '15.56', NULL, '2019-06-18 14:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (96, 2, 8416260096, 5634678784, 2781581312, '66.95', NULL, '2019-06-18 14:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (97, 1, NULL, NULL, NULL, '12.24', NULL, '2019-06-18 14:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (98, 2, 8416260096, 5608443904, 2807816192, '66.64', NULL, '2019-06-18 14:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (99, 1, NULL, NULL, NULL, '14.51', NULL, '2019-06-18 14:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (100, 2, 8416260096, 5730234368, 2686025728, '68.09', NULL, '2019-06-18 14:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (101, 1, NULL, NULL, NULL, '20.95', NULL, '2019-06-18 14:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (102, 2, 8416260096, 5676015616, 2740244480, '67.44', NULL, '2019-06-18 14:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (103, 1, NULL, NULL, NULL, '19.38', NULL, '2019-06-18 14:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (104, 2, 8416260096, 5736521728, 2679738368, '68.16', NULL, '2019-06-18 14:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (105, 1, NULL, NULL, NULL, '17.90', NULL, '2019-06-18 14:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (106, 2, 8416260096, 5676109824, 2740150272, '67.44', NULL, '2019-06-18 14:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (107, 1, NULL, NULL, NULL, '14.24', NULL, '2019-06-18 14:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (108, 2, 8416260096, 5557018624, 2859241472, '66.03', NULL, '2019-06-18 14:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (109, 1, NULL, NULL, NULL, '12.96', NULL, '2019-06-18 14:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (110, 2, 8416260096, 5481213952, 2935046144, '65.13', NULL, '2019-06-18 14:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (111, 1, NULL, NULL, NULL, '11.87', NULL, '2019-06-18 14:39:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (112, 2, 8416260096, 5461540864, 2954719232, '64.89', NULL, '2019-06-18 14:39:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (113, 1, NULL, NULL, NULL, '12.40', NULL, '2019-06-18 14:39:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (114, 2, 8416260096, 5392052224, 3024207872, '64.07', NULL, '2019-06-18 14:39:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (115, 1, NULL, NULL, NULL, '12.21', NULL, '2019-06-18 14:40:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (116, 2, 8416260096, 5373628416, 3042631680, '63.85', NULL, '2019-06-18 14:40:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (117, 1, NULL, NULL, NULL, '12.14', NULL, '2019-06-18 14:40:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (118, 2, 8416260096, 5309640704, 3106619392, '63.09', NULL, '2019-06-18 14:40:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (119, 1, NULL, NULL, NULL, '12.89', NULL, '2019-06-18 14:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (120, 2, 8416260096, 5300731904, 3115528192, '62.98', NULL, '2019-06-18 14:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (121, 1, NULL, NULL, NULL, '13.26', NULL, '2019-06-18 14:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (122, 2, 8416260096, 5294268416, 3121991680, '62.91', NULL, '2019-06-18 14:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (123, 1, NULL, NULL, NULL, '12.71', NULL, '2019-06-18 14:42:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (124, 2, 8416260096, 5264953344, 3151306752, '62.56', NULL, '2019-06-18 14:42:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (125, 1, NULL, NULL, NULL, '12.30', NULL, '2019-06-18 14:42:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (126, 2, 8416260096, 5244235776, 3172024320, '62.31', NULL, '2019-06-18 14:42:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (127, 1, NULL, NULL, NULL, '12.17', NULL, '2019-06-18 14:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (128, 2, 8416260096, 5238792192, 3177467904, '62.25', NULL, '2019-06-18 14:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (129, 1, NULL, NULL, NULL, '12.12', NULL, '2019-06-18 14:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (130, 2, 8416260096, 5247012864, 3169247232, '62.34', NULL, '2019-06-18 14:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (131, 1, NULL, NULL, NULL, '12.03', NULL, '2019-06-18 14:44:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (132, 2, 8416260096, 5245956096, 3170304000, '62.33', NULL, '2019-06-18 14:44:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (133, 1, NULL, NULL, NULL, '12.45', NULL, '2019-06-18 14:44:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (134, 2, 8416260096, 5259259904, 3157000192, '62.49', NULL, '2019-06-18 14:44:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (135, 1, NULL, NULL, NULL, '12.96', NULL, '2019-06-18 14:45:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (136, 2, 8416260096, 5270614016, 3145646080, '62.62', NULL, '2019-06-18 14:45:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (137, 1, NULL, NULL, NULL, '13.20', NULL, '2019-06-18 14:45:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (138, 2, 8416260096, 5260836864, 3155423232, '62.51', NULL, '2019-06-18 14:45:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (139, 1, NULL, NULL, NULL, '12.46', NULL, '2019-06-18 14:46:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (140, 2, 8416260096, 5261012992, 3155247104, '62.51', NULL, '2019-06-18 14:46:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (141, 1, NULL, NULL, NULL, '12.01', NULL, '2019-06-18 14:46:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (142, 2, 8416260096, 5253378048, 3162882048, '62.42', NULL, '2019-06-18 14:46:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (143, 1, NULL, NULL, NULL, '12.30', NULL, '2019-06-18 14:47:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (144, 2, 8416260096, 5252988928, 3163271168, '62.41', NULL, '2019-06-18 14:47:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (145, 1, NULL, NULL, NULL, '13.06', NULL, '2019-06-18 14:47:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (146, 2, 8416260096, 5251899392, 3164360704, '62.40', NULL, '2019-06-18 14:47:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (147, 1, NULL, NULL, NULL, '12.55', NULL, '2019-06-18 14:48:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (148, 2, 8416260096, 5189771264, 3226488832, '61.66', NULL, '2019-06-18 14:48:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (149, 1, NULL, NULL, NULL, '13.39', NULL, '2019-06-18 14:48:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (150, 2, 8416260096, 5194477568, 3221782528, '61.72', NULL, '2019-06-18 14:48:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (151, 1, NULL, NULL, NULL, '13.50', NULL, '2019-06-18 14:49:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (152, 2, 8416260096, 5187379200, 3228880896, '61.64', NULL, '2019-06-18 14:49:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (153, 1, NULL, NULL, NULL, '12.60', NULL, '2019-06-18 14:49:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (154, 2, 8416260096, 5198749696, 3217510400, '61.77', NULL, '2019-06-18 14:49:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (155, 1, NULL, NULL, NULL, '12.59', NULL, '2019-06-18 14:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (156, 2, 8416260096, 5184688128, 3231571968, '61.60', NULL, '2019-06-18 14:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (157, 1, NULL, NULL, NULL, '12.03', NULL, '2019-06-18 14:50:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (158, 2, 8416260096, 5184212992, 3232047104, '61.60', NULL, '2019-06-18 14:50:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (159, 1, NULL, NULL, NULL, '12.64', NULL, '2019-06-18 14:51:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (160, 2, 8416260096, 5186568192, 3229691904, '61.63', NULL, '2019-06-18 14:51:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (161, 1, NULL, NULL, NULL, '12.20', NULL, '2019-06-18 14:51:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (162, 2, 8416260096, 5207834624, 3208425472, '61.88', NULL, '2019-06-18 14:51:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (163, 1, NULL, NULL, NULL, '12.08', NULL, '2019-06-18 14:52:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (164, 2, 8416260096, 5207498752, 3208761344, '61.87', NULL, '2019-06-18 14:52:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (165, 1, NULL, NULL, NULL, '14.17', NULL, '2019-06-18 14:52:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (166, 2, 8416260096, 5227769856, 3188490240, '62.12', NULL, '2019-06-18 14:52:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (167, 1, NULL, NULL, NULL, '10.91', NULL, '2019-06-18 15:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (168, 2, 8416260096, 6224998400, 2191261696, '73.96', NULL, '2019-06-18 15:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (169, 1, NULL, NULL, NULL, '13.43', NULL, '2019-06-18 15:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (170, 2, 8416260096, 6235095040, 2181165056, '74.08', NULL, '2019-06-18 15:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (171, 1, NULL, NULL, NULL, '5.24', NULL, '2019-06-18 17:55:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (172, 2, 8428691456, 6739124224, 1689567232, '79.95', NULL, '2019-06-18 17:55:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (173, 1, NULL, NULL, NULL, '8.54', NULL, '2019-06-19 15:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (174, 2, 8428691456, 6228791296, 2199900160, '73.90', NULL, '2019-06-19 15:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (175, 1, NULL, NULL, NULL, '8.55', NULL, '2019-06-19 15:57:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (176, 2, 8428691456, 6150856704, 2277834752, '72.98', NULL, '2019-06-19 15:57:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (177, 1, NULL, NULL, NULL, '6.82', NULL, '2019-06-20 16:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (178, 2, 8416260096, 6226194432, 2190065664, '73.98', NULL, '2019-06-20 16:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (179, 1, NULL, NULL, NULL, '4.53', NULL, '2019-06-20 16:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (180, 2, 8416260096, 6195310592, 2220949504, '73.61', NULL, '2019-06-20 16:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (181, 1, NULL, NULL, NULL, '6.88', NULL, '2019-06-20 17:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (182, 2, 8416260096, 5385293824, 3030966272, '63.99', NULL, '2019-06-20 17:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (183, 1, NULL, NULL, NULL, '6.71', NULL, '2019-06-20 17:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (184, 2, 8416260096, 5314306048, 3101954048, '63.14', NULL, '2019-06-20 17:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (185, 1, NULL, NULL, NULL, '21.04', NULL, '2019-06-20 17:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (186, 2, 8416260096, 5807194112, 2609065984, '69.00', NULL, '2019-06-20 17:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (187, 1, NULL, NULL, NULL, '6.35', NULL, '2019-06-20 17:33:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (188, 2, 8416260096, 5697994752, 2718265344, '67.70', NULL, '2019-06-20 17:33:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (189, 1, NULL, NULL, NULL, '4.92', NULL, '2019-06-20 17:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (190, 2, 8416260096, 5602803712, 2813456384, '66.57', NULL, '2019-06-20 17:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (191, 1, NULL, NULL, NULL, '7.27', NULL, '2019-06-20 17:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (192, 2, 8416260096, 5504663552, 2911596544, '65.41', NULL, '2019-06-20 17:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (193, 1, NULL, NULL, NULL, '14.18', NULL, '2019-06-20 18:03:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (194, 2, 8561680384, 5023789056, 3537891328, '58.68', NULL, '2019-06-20 18:03:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (195, 1, NULL, NULL, NULL, '14.21', NULL, '2019-06-20 18:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (196, 2, 8561680384, 5160427520, 3401252864, '60.27', NULL, '2019-06-20 18:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (197, 1, NULL, NULL, NULL, '20.15', NULL, '2019-06-20 18:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (198, 2, 8561680384, 5081710592, 3479969792, '59.35', NULL, '2019-06-20 18:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (199, 1, NULL, NULL, NULL, '14.22', NULL, '2019-06-20 18:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (200, 2, 8561680384, 4853444608, 3708235776, '56.69', NULL, '2019-06-20 18:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (201, 1, NULL, NULL, NULL, '25.04', NULL, '2019-06-20 18:12:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (202, 2, 8561680384, 4909158400, 3652521984, '57.34', NULL, '2019-06-20 18:12:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (203, 1, NULL, NULL, NULL, '16.99', NULL, '2019-06-20 18:13:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (204, 2, 8561680384, 4972548096, 3589132288, '58.08', NULL, '2019-06-20 18:13:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (205, 1, NULL, NULL, NULL, '17.01', NULL, '2019-06-20 18:13:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (206, 2, 8561680384, 4970160128, 3591520256, '58.05', NULL, '2019-06-20 18:13:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (207, 1, NULL, NULL, NULL, '15.16', NULL, '2019-06-20 18:14:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (208, 2, 8561680384, 4951478272, 3610202112, '57.83', NULL, '2019-06-20 18:14:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (209, 1, NULL, NULL, NULL, '18.80', NULL, '2019-06-20 18:14:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (210, 2, 8561680384, 4988248064, 3573432320, '58.26', NULL, '2019-06-20 18:14:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (211, 1, NULL, NULL, NULL, '30.50', NULL, '2019-06-20 18:15:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (212, 2, 8561680384, 4982362112, 3579318272, '58.19', NULL, '2019-06-20 18:15:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (213, 1, NULL, NULL, NULL, '29.88', NULL, '2019-06-20 18:15:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (214, 2, 8561680384, 4923416576, 3638263808, '57.51', NULL, '2019-06-20 18:15:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (215, 1, NULL, NULL, NULL, '24.67', NULL, '2019-06-20 18:16:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (216, 2, 8561680384, 4942049280, 3619631104, '57.72', NULL, '2019-06-20 18:16:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (217, 1, NULL, NULL, NULL, '16.74', NULL, '2019-06-20 18:16:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (218, 2, 8561680384, 4725071872, 3836608512, '55.19', NULL, '2019-06-20 18:16:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (219, 1, NULL, NULL, NULL, '31.15', NULL, '2019-06-20 18:17:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (220, 2, 8561680384, 4874457088, 3687223296, '56.93', NULL, '2019-06-20 18:17:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (221, 1, NULL, NULL, NULL, '19.27', NULL, '2019-06-20 18:17:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (222, 2, 8561680384, 4823826432, 3737853952, '56.34', NULL, '2019-06-20 18:17:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (223, 1, NULL, NULL, NULL, '11.62', NULL, '2019-06-20 18:18:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (224, 2, 8561680384, 4814602240, 3747078144, '56.23', NULL, '2019-06-20 18:18:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (225, 1, NULL, NULL, NULL, '15.07', NULL, '2019-06-20 18:18:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (226, 2, 8561680384, 4791762944, 3769917440, '55.97', NULL, '2019-06-20 18:18:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (227, 1, NULL, NULL, NULL, '21.50', NULL, '2019-06-20 18:19:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (228, 2, 8561680384, 4795944960, 3765735424, '56.02', NULL, '2019-06-20 18:19:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (229, 1, NULL, NULL, NULL, '26.89', NULL, '2019-06-20 18:19:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (230, 2, 8561680384, 4813234176, 3748446208, '56.22', NULL, '2019-06-20 18:19:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (231, 1, NULL, NULL, NULL, '22.60', NULL, '2019-06-20 18:20:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (232, 2, 8561680384, 4846833664, 3714846720, '56.61', NULL, '2019-06-20 18:20:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (233, 1, NULL, NULL, NULL, '24.57', NULL, '2019-06-20 18:20:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (234, 2, 8561680384, 4790759424, 3770920960, '55.96', NULL, '2019-06-20 18:20:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (235, 1, NULL, NULL, NULL, '12.88', NULL, '2019-06-20 18:21:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (236, 2, 8561680384, 4785152000, 3776528384, '55.89', NULL, '2019-06-20 18:21:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (237, 1, NULL, NULL, NULL, '15.56', NULL, '2019-06-20 18:21:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (238, 2, 8561680384, 4783308800, 3778371584, '55.87', NULL, '2019-06-20 18:21:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (239, 1, NULL, NULL, NULL, '15.05', NULL, '2019-06-20 18:22:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (240, 2, 8561680384, 4778635264, 3783045120, '55.81', NULL, '2019-06-20 18:22:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (241, 1, NULL, NULL, NULL, '14.24', NULL, '2019-06-20 18:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (242, 2, 8561680384, 4589596672, 3972083712, '53.61', NULL, '2019-06-20 18:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (243, 1, NULL, NULL, NULL, '14.24', NULL, '2019-06-20 18:26:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (244, 2, 8561680384, 4723077120, 3838603264, '55.17', NULL, '2019-06-20 18:26:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (245, 1, NULL, NULL, NULL, '5.66', NULL, '2019-06-20 18:27:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (246, 2, 8561680384, 4708360192, 3853320192, '54.99', NULL, '2019-06-20 18:27:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (247, 1, NULL, NULL, NULL, '9.99', NULL, '2019-06-20 18:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (248, 2, 8561680384, 4705546240, 3856134144, '54.96', NULL, '2019-06-20 18:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (249, 1, NULL, NULL, NULL, '14.24', NULL, '2019-06-20 18:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (250, 2, 8561680384, 4850806784, 3710873600, '56.66', NULL, '2019-06-20 18:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (251, 1, NULL, NULL, NULL, '13.18', NULL, '2019-06-20 18:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (252, 2, 8561680384, 4681084928, 3880595456, '54.67', NULL, '2019-06-20 18:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (253, 1, NULL, NULL, NULL, '14.09', NULL, '2019-06-20 18:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (254, 2, 8561680384, 4575760384, 3985920000, '53.44', NULL, '2019-06-20 18:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (255, 1, NULL, NULL, NULL, '6.67', NULL, '2019-06-20 18:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (256, 2, 8561680384, 4134625280, 4427055104, '48.29', NULL, '2019-06-20 18:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (257, 1, NULL, NULL, NULL, '9.35', NULL, '2019-06-20 18:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (258, 2, 8561680384, 4168798208, 4392882176, '48.69', NULL, '2019-06-20 18:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (259, 1, NULL, NULL, NULL, '10.19', NULL, '2019-06-21 10:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (260, 2, 8504745984, 6849720320, 1655025664, '80.54', NULL, '2019-06-21 10:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (261, 1, NULL, NULL, NULL, '27.56', NULL, '2019-06-21 10:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (262, 2, 8504745984, 6753435648, 1751310336, '79.41', NULL, '2019-06-21 10:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (263, 1, NULL, NULL, NULL, '23.84', NULL, '2019-06-21 10:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (264, 2, 8504745984, 6777450496, 1727295488, '79.69', NULL, '2019-06-21 10:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (265, 1, NULL, NULL, NULL, '36.17', NULL, '2019-06-21 10:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (266, 2, 8504745984, 6973374464, 1531371520, '81.99', NULL, '2019-06-21 10:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (267, 1, NULL, NULL, NULL, '34.45', NULL, '2019-06-21 10:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (268, 2, 8504745984, 6304780288, 2199965696, '74.13', NULL, '2019-06-21 10:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (269, 1, NULL, NULL, NULL, '55.28', NULL, '2019-06-21 10:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (270, 2, 8504745984, 6787932160, 1716813824, '79.81', NULL, '2019-06-21 10:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (271, 1, NULL, NULL, NULL, '28.88', NULL, '2019-06-21 10:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (272, 2, 8504745984, 6538645504, 1966100480, '76.88', NULL, '2019-06-21 10:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (273, 1, NULL, NULL, NULL, '20.36', NULL, '2019-06-21 10:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (274, 2, 8504745984, 6417367040, 2087378944, '75.46', NULL, '2019-06-21 10:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (275, 1, NULL, NULL, NULL, '21.58', NULL, '2019-06-21 10:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (276, 2, 8504745984, 6331473920, 2173272064, '74.45', NULL, '2019-06-21 10:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (277, 1, NULL, NULL, NULL, '10.23', NULL, '2019-06-21 10:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (278, 2, 8504745984, 6308823040, 2195922944, '74.18', NULL, '2019-06-21 10:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (279, 1, NULL, NULL, NULL, '35.10', NULL, '2019-06-21 10:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (280, 2, 8504745984, 6009180160, 2495565824, '70.66', NULL, '2019-06-21 10:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (281, 1, NULL, NULL, NULL, '10.24', NULL, '2019-06-21 10:44:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (282, 2, 8504745984, 6500286464, 2004459520, '76.43', NULL, '2019-06-21 10:44:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (283, 1, NULL, NULL, NULL, '21.76', NULL, '2019-06-21 10:45:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (284, 2, 8504745984, 6478254080, 2026491904, '76.17', NULL, '2019-06-21 10:45:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (285, 1, NULL, NULL, NULL, '10.25', NULL, '2019-06-21 10:46:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (286, 2, 8504745984, 6190489600, 2314256384, '72.79', NULL, '2019-06-21 10:46:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (287, 1, NULL, NULL, NULL, '21.39', NULL, '2019-06-21 10:46:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (288, 2, 8504745984, 6132572160, 2372173824, '72.11', NULL, '2019-06-21 10:46:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (289, 1, NULL, NULL, NULL, '27.15', NULL, '2019-06-21 10:47:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (290, 2, 8504745984, 6131552256, 2373193728, '72.10', NULL, '2019-06-21 10:47:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (291, 1, NULL, NULL, NULL, '14.95', NULL, '2019-06-21 10:48:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (292, 2, 8561680384, 4909666304, 3652014080, '57.34', NULL, '2019-06-21 10:48:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (293, 1, NULL, NULL, NULL, '10.27', NULL, '2019-06-21 10:48:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (294, 2, 8504745984, 6095933440, 2408812544, '71.68', NULL, '2019-06-21 10:48:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (295, 1, NULL, NULL, NULL, '47.12', NULL, '2019-06-21 10:48:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (296, 2, 8561680384, 4882345984, 3679334400, '57.03', NULL, '2019-06-21 10:48:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (297, 1, NULL, NULL, NULL, '27.22', NULL, '2019-06-21 10:48:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (298, 2, 8504745984, 5911715840, 2593030144, '69.51', NULL, '2019-06-21 10:48:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (299, 1, NULL, NULL, NULL, '38.20', NULL, '2019-06-21 10:49:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (300, 2, 8504745984, 6108852224, 2395893760, '71.83', NULL, '2019-06-21 10:49:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (301, 1, NULL, NULL, NULL, '29.22', NULL, '2019-06-21 10:49:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (302, 2, 8504745984, 6119747584, 2384998400, '71.96', NULL, '2019-06-21 10:49:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (303, 1, NULL, NULL, NULL, '27.88', NULL, '2019-06-21 10:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (304, 2, 8504745984, 6064660480, 2440085504, '71.31', NULL, '2019-06-21 10:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (305, 1, NULL, NULL, NULL, '23.53', NULL, '2019-06-21 10:50:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (306, 2, 8504745984, 5983698944, 2521047040, '70.36', NULL, '2019-06-21 10:50:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (307, 1, NULL, NULL, NULL, '20.87', NULL, '2019-06-21 10:51:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (308, 2, 8504745984, 5911453696, 2593292288, '69.51', NULL, '2019-06-21 10:51:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (309, 1, NULL, NULL, NULL, '20.68', NULL, '2019-06-21 10:51:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (310, 2, 8504745984, 5818511360, 2686234624, '68.41', NULL, '2019-06-21 10:51:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (311, 1, NULL, NULL, NULL, '20.77', NULL, '2019-06-21 10:52:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (312, 2, 8504745984, 5751230464, 2753515520, '67.62', NULL, '2019-06-21 10:52:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (313, 1, NULL, NULL, NULL, '20.30', NULL, '2019-06-21 10:52:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (314, 2, 8504745984, 5678026752, 2826719232, '66.76', NULL, '2019-06-21 10:52:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (315, 1, NULL, NULL, NULL, '20.13', NULL, '2019-06-21 10:53:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (316, 2, 8504745984, 5673775104, 2830970880, '66.71', NULL, '2019-06-21 10:53:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (317, 1, NULL, NULL, NULL, '21.80', NULL, '2019-06-21 10:53:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (318, 2, 8504745984, 5680664576, 2824081408, '66.79', NULL, '2019-06-21 10:53:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (319, 1, NULL, NULL, NULL, '23.75', NULL, '2019-06-21 10:54:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (320, 2, 8504745984, 5634146304, 2870599680, '66.25', NULL, '2019-06-21 10:54:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (321, 1, NULL, NULL, NULL, '21.14', NULL, '2019-06-21 10:54:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (322, 2, 8504745984, 5618536448, 2886209536, '66.06', NULL, '2019-06-21 10:54:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (323, 1, NULL, NULL, NULL, '21.19', NULL, '2019-06-21 10:55:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (324, 2, 8504745984, 5591740416, 2913005568, '65.75', NULL, '2019-06-21 10:55:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (325, 1, NULL, NULL, NULL, '19.23', NULL, '2019-06-21 10:55:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (326, 2, 8504745984, 5606084608, 2898661376, '65.92', NULL, '2019-06-21 10:55:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (327, 1, NULL, NULL, NULL, '21.02', NULL, '2019-06-21 10:56:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (328, 2, 8504745984, 5616586752, 2888159232, '66.04', NULL, '2019-06-21 10:56:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (329, 1, NULL, NULL, NULL, '21.35', NULL, '2019-06-21 10:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (330, 2, 8504745984, 5623070720, 2881675264, '66.12', NULL, '2019-06-21 10:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (331, 1, NULL, NULL, NULL, '19.78', NULL, '2019-06-21 10:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (332, 2, 8504745984, 5622398976, 2882347008, '66.11', NULL, '2019-06-21 10:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (333, 1, NULL, NULL, NULL, '21.35', NULL, '2019-06-21 10:57:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (334, 2, 8504745984, 5599408128, 2905337856, '65.84', NULL, '2019-06-21 10:57:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (335, 1, NULL, NULL, NULL, '21.12', NULL, '2019-06-21 10:58:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (336, 2, 8504745984, 5604610048, 2900135936, '65.90', NULL, '2019-06-21 10:58:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (337, 1, NULL, NULL, NULL, '23.18', NULL, '2019-06-21 10:58:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (338, 2, 8504745984, 5622059008, 2882686976, '66.10', NULL, '2019-06-21 10:58:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (339, 1, NULL, NULL, NULL, '21.59', NULL, '2019-06-21 10:59:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (340, 2, 8504745984, 5618421760, 2886324224, '66.06', NULL, '2019-06-21 10:59:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (341, 1, NULL, NULL, NULL, '20.26', NULL, '2019-06-21 10:59:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (342, 2, 8504745984, 5624287232, 2880458752, '66.13', NULL, '2019-06-21 10:59:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (343, 1, NULL, NULL, NULL, '20.43', NULL, '2019-06-21 11:00:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (344, 2, 8504745984, 5634510848, 2870235136, '66.25', NULL, '2019-06-21 11:00:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (345, 1, NULL, NULL, NULL, '19.97', NULL, '2019-06-21 11:00:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (346, 2, 8504745984, 5584908288, 2919837696, '65.67', NULL, '2019-06-21 11:00:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (347, 1, NULL, NULL, NULL, '21.13', NULL, '2019-06-21 11:01:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (348, 2, 8504745984, 5601140736, 2903605248, '65.86', NULL, '2019-06-21 11:01:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (349, 1, NULL, NULL, NULL, '20.39', NULL, '2019-06-21 11:01:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (350, 2, 8504745984, 5595131904, 2909614080, '65.79', NULL, '2019-06-21 11:01:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (351, 1, NULL, NULL, NULL, '22.14', NULL, '2019-06-21 11:02:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (352, 2, 8504745984, 5607202816, 2897543168, '65.93', NULL, '2019-06-21 11:02:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (353, 1, NULL, NULL, NULL, '20.75', NULL, '2019-06-21 11:02:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (354, 2, 8504745984, 5600841728, 2903904256, '65.86', NULL, '2019-06-21 11:02:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (355, 1, NULL, NULL, NULL, '19.97', NULL, '2019-06-21 11:03:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (356, 2, 8504745984, 5599559680, 2905186304, '65.84', NULL, '2019-06-21 11:03:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (357, 1, NULL, NULL, NULL, '20.68', NULL, '2019-06-21 11:03:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (358, 2, 8504745984, 5599543296, 2905202688, '65.84', NULL, '2019-06-21 11:03:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (359, 1, NULL, NULL, NULL, '20.42', NULL, '2019-06-21 11:04:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (360, 2, 8504745984, 5619232768, 2885513216, '66.07', NULL, '2019-06-21 11:04:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (361, 1, NULL, NULL, NULL, '20.08', NULL, '2019-06-21 11:04:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (362, 2, 8504745984, 5669568512, 2835177472, '66.66', NULL, '2019-06-21 11:04:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (363, 1, NULL, NULL, NULL, '20.18', NULL, '2019-06-21 11:05:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (364, 2, 8504745984, 5641990144, 2862755840, '66.34', NULL, '2019-06-21 11:05:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (365, 1, NULL, NULL, NULL, '20.38', NULL, '2019-06-21 11:05:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (366, 2, 8504745984, 5639475200, 2865270784, '66.31', NULL, '2019-06-21 11:05:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (367, 1, NULL, NULL, NULL, '21.51', NULL, '2019-06-21 11:06:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (368, 2, 8504745984, 5643018240, 2861727744, '66.35', NULL, '2019-06-21 11:06:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (369, 1, NULL, NULL, NULL, '19.81', NULL, '2019-06-21 11:06:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (370, 2, 8504745984, 5639163904, 2865582080, '66.31', NULL, '2019-06-21 11:06:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (371, 1, NULL, NULL, NULL, '21.25', NULL, '2019-06-21 11:07:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (372, 2, 8504745984, 5624803328, 2879942656, '66.14', NULL, '2019-06-21 11:07:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (373, 1, NULL, NULL, NULL, '18.97', NULL, '2019-06-21 11:07:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (374, 2, 8504745984, 5621571584, 2883174400, '66.10', NULL, '2019-06-21 11:07:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (375, 1, NULL, NULL, NULL, '20.44', NULL, '2019-06-21 11:08:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (376, 2, 8504745984, 5624864768, 2879881216, '66.14', NULL, '2019-06-21 11:08:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (377, 1, NULL, NULL, NULL, '19.99', NULL, '2019-06-21 11:08:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (378, 2, 8504745984, 5609984000, 2894761984, '65.96', NULL, '2019-06-21 11:08:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (379, 1, NULL, NULL, NULL, '19.60', NULL, '2019-06-21 11:09:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (380, 2, 8504745984, 5629374464, 2875371520, '66.19', NULL, '2019-06-21 11:09:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (381, 1, NULL, NULL, NULL, '19.62', NULL, '2019-06-21 11:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (382, 2, 8504745984, 5633118208, 2871627776, '66.23', NULL, '2019-06-21 11:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (383, 1, NULL, NULL, NULL, '20.39', NULL, '2019-06-21 11:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (384, 2, 8504745984, 5634293760, 2870452224, '66.25', NULL, '2019-06-21 11:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (385, 1, NULL, NULL, NULL, '22.60', NULL, '2019-06-21 11:10:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (386, 2, 8504745984, 5649297408, 2855448576, '66.43', NULL, '2019-06-21 11:10:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (387, 1, NULL, NULL, NULL, '29.49', NULL, '2019-06-21 11:11:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (388, 2, 8504745984, 5801328640, 2703417344, '68.21', NULL, '2019-06-21 11:11:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (389, 1, NULL, NULL, NULL, '20.30', NULL, '2019-06-21 11:11:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (390, 2, 8504745984, 5787480064, 2717265920, '68.05', NULL, '2019-06-21 11:11:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (391, 1, NULL, NULL, NULL, '19.13', NULL, '2019-06-21 11:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (392, 2, 8504745984, 5766782976, 2737963008, '67.81', NULL, '2019-06-21 11:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (393, 1, NULL, NULL, NULL, '19.61', NULL, '2019-06-21 11:12:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (394, 2, 8504745984, 5752008704, 2752737280, '67.63', NULL, '2019-06-21 11:12:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (395, 1, NULL, NULL, NULL, '21.21', NULL, '2019-06-21 11:13:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (396, 2, 8504745984, 5757366272, 2747379712, '67.70', NULL, '2019-06-21 11:13:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (397, 1, NULL, NULL, NULL, '19.58', NULL, '2019-06-21 11:13:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (398, 2, 8504745984, 5750988800, 2753757184, '67.62', NULL, '2019-06-21 11:13:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (399, 1, NULL, NULL, NULL, '19.48', NULL, '2019-06-21 11:14:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (400, 2, 8504745984, 5753245696, 2751500288, '67.65', NULL, '2019-06-21 11:14:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (401, 1, NULL, NULL, NULL, '20.04', NULL, '2019-06-21 11:14:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (402, 2, 8504745984, 5711548416, 2793197568, '67.16', NULL, '2019-06-21 11:14:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (403, 1, NULL, NULL, NULL, '21.99', NULL, '2019-06-21 11:15:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (404, 2, 8504745984, 5720453120, 2784292864, '67.26', NULL, '2019-06-21 11:15:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (405, 1, NULL, NULL, NULL, '22.75', NULL, '2019-06-21 11:15:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (406, 2, 8504745984, 5716541440, 2788204544, '67.22', NULL, '2019-06-21 11:15:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (407, 1, NULL, NULL, NULL, '20.55', NULL, '2019-06-21 11:16:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (408, 2, 8504745984, 5704069120, 2800676864, '67.07', NULL, '2019-06-21 11:16:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (409, 1, NULL, NULL, NULL, '19.28', NULL, '2019-06-21 11:16:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (410, 2, 8504745984, 5695479808, 2809266176, '66.97', NULL, '2019-06-21 11:16:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (411, 1, NULL, NULL, NULL, '22.92', NULL, '2019-06-21 11:17:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (412, 2, 8504745984, 5769043968, 2735702016, '67.83', NULL, '2019-06-21 11:17:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (413, 1, NULL, NULL, NULL, '20.81', NULL, '2019-06-21 11:17:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (414, 2, 8504745984, 5672992768, 2831753216, '66.70', NULL, '2019-06-21 11:17:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (415, 1, NULL, NULL, NULL, '20.31', NULL, '2019-06-21 11:18:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (416, 2, 8504745984, 5655482368, 2849263616, '66.50', NULL, '2019-06-21 11:18:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (417, 1, NULL, NULL, NULL, '19.06', NULL, '2019-06-21 11:18:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (418, 2, 8504745984, 5606154240, 2898591744, '65.92', NULL, '2019-06-21 11:18:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (419, 1, NULL, NULL, NULL, '20.83', NULL, '2019-06-21 11:19:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (420, 2, 8504745984, 5639892992, 2864852992, '66.31', NULL, '2019-06-21 11:19:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (421, 1, NULL, NULL, NULL, '20.92', NULL, '2019-06-21 11:19:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (422, 2, 8504745984, 5652447232, 2852298752, '66.46', NULL, '2019-06-21 11:19:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (423, 1, NULL, NULL, NULL, '23.45', NULL, '2019-06-21 11:20:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (424, 2, 8504745984, 5655261184, 2849484800, '66.50', NULL, '2019-06-21 11:20:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (425, 1, NULL, NULL, NULL, '21.05', NULL, '2019-06-21 11:20:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (426, 2, 8504745984, 5649199104, 2855546880, '66.42', NULL, '2019-06-21 11:20:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (427, 1, NULL, NULL, NULL, '20.24', NULL, '2019-06-21 11:21:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (428, 2, 8504745984, 5671636992, 2833108992, '66.69', NULL, '2019-06-21 11:21:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (429, 1, NULL, NULL, NULL, '20.04', NULL, '2019-06-21 11:21:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (430, 2, 8504745984, 5657473024, 2847272960, '66.52', NULL, '2019-06-21 11:21:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (431, 1, NULL, NULL, NULL, '22.97', NULL, '2019-06-21 11:22:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (432, 2, 8504745984, 5666574336, 2838171648, '66.63', NULL, '2019-06-21 11:22:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (433, 1, NULL, NULL, NULL, '25.82', NULL, '2019-06-21 11:22:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (434, 2, 8504745984, 5262712832, 3242033152, '61.88', NULL, '2019-06-21 11:22:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (435, 1, NULL, NULL, NULL, '18.50', NULL, '2019-06-21 11:23:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (436, 2, 8504745984, 5259669504, 3245076480, '61.84', NULL, '2019-06-21 11:23:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (437, 1, NULL, NULL, NULL, '18.92', NULL, '2019-06-21 11:23:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (438, 2, 8504745984, 5265444864, 3239301120, '61.91', NULL, '2019-06-21 11:23:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (439, 1, NULL, NULL, NULL, '20.98', NULL, '2019-06-21 11:24:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (440, 2, 8504745984, 5299949568, 3204796416, '62.32', NULL, '2019-06-21 11:24:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (441, 1, NULL, NULL, NULL, '21.55', NULL, '2019-06-21 11:24:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (442, 2, 8504745984, 5308002304, 3196743680, '62.41', NULL, '2019-06-21 11:24:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (443, 1, NULL, NULL, NULL, '21.37', NULL, '2019-06-21 11:25:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (444, 2, 8504745984, 5281959936, 3222786048, '62.11', NULL, '2019-06-21 11:25:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (445, 1, NULL, NULL, NULL, '19.32', NULL, '2019-06-21 11:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (446, 2, 8504745984, 5278904320, 3225841664, '62.07', NULL, '2019-06-21 11:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (447, 1, NULL, NULL, NULL, '19.21', NULL, '2019-06-21 11:26:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (448, 2, 8504745984, 5295845376, 3208900608, '62.27', NULL, '2019-06-21 11:26:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (449, 1, NULL, NULL, NULL, '14.89', NULL, '2019-06-21 11:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (450, 2, 8561680384, 4602707968, 3958972416, '53.76', NULL, '2019-06-21 11:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (451, 1, NULL, NULL, NULL, '38.68', NULL, '2019-06-21 11:28:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (452, 2, 8561680384, 4727418880, 3834261504, '55.22', NULL, '2019-06-21 11:28:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (453, 1, NULL, NULL, NULL, '13.23', NULL, '2019-06-21 11:28:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (454, 2, 8561680384, 4638498816, 3923181568, '54.18', NULL, '2019-06-21 11:28:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (455, 1, NULL, NULL, NULL, '16.24', NULL, '2019-06-21 11:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (456, 2, 8561680384, 4357595136, 4204085248, '50.90', NULL, '2019-06-21 11:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (457, 1, NULL, NULL, NULL, '10.18', NULL, '2019-06-21 11:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (458, 2, 8561680384, 4340916224, 4220764160, '50.70', NULL, '2019-06-21 11:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (459, 1, NULL, NULL, NULL, '11.86', NULL, '2019-06-21 11:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (460, 2, 8561680384, 4308713472, 4252966912, '50.33', NULL, '2019-06-21 11:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (461, 1, NULL, NULL, NULL, '11.93', NULL, '2019-06-21 11:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (462, 2, 8561680384, 4255039488, 4306640896, '49.70', NULL, '2019-06-21 11:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (463, 1, NULL, NULL, NULL, '11.55', NULL, '2019-06-21 11:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (464, 2, 8561680384, 4175622144, 4386058240, '48.77', NULL, '2019-06-21 11:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (465, 1, NULL, NULL, NULL, '10.95', NULL, '2019-06-21 11:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (466, 2, 8561680384, 4144209920, 4417470464, '48.40', NULL, '2019-06-21 11:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (467, 1, NULL, NULL, NULL, '11.89', NULL, '2019-06-21 11:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (468, 2, 8561680384, 4106944512, 4454735872, '47.97', NULL, '2019-06-21 11:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (469, 1, NULL, NULL, NULL, '9.62', NULL, '2019-06-21 11:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (470, 2, 8561680384, 4077572096, 4484108288, '47.63', NULL, '2019-06-21 11:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (471, 1, NULL, NULL, NULL, '14.60', NULL, '2019-06-21 11:33:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (472, 2, 8561680384, 4059906048, 4501774336, '47.42', NULL, '2019-06-21 11:33:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (473, 1, NULL, NULL, NULL, '18.01', NULL, '2019-06-21 11:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (474, 2, 8561680384, 4037001216, 4524679168, '47.15', NULL, '2019-06-21 11:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (475, 1, NULL, NULL, NULL, '11.77', NULL, '2019-06-21 11:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (476, 2, 8561680384, 4028354560, 4533325824, '47.05', NULL, '2019-06-21 11:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (477, 1, NULL, NULL, NULL, '11.03', NULL, '2019-06-21 11:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (478, 2, 8561680384, 3991523328, 4570157056, '46.62', NULL, '2019-06-21 11:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (479, 1, NULL, NULL, NULL, '9.40', NULL, '2019-06-21 11:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (480, 2, 8561680384, 3983863808, 4577816576, '46.53', NULL, '2019-06-21 11:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (481, 1, NULL, NULL, NULL, '10.21', NULL, '2019-06-21 11:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (482, 2, 8561680384, 3954221056, 4607459328, '46.19', NULL, '2019-06-21 11:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (483, 1, NULL, NULL, NULL, '11.60', NULL, '2019-06-21 11:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (484, 2, 8561680384, 3941900288, 4619780096, '46.04', NULL, '2019-06-21 11:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (485, 1, NULL, NULL, NULL, '11.89', NULL, '2019-06-21 11:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (486, 2, 8561680384, 3920564224, 4641116160, '45.79', NULL, '2019-06-21 11:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (487, 1, NULL, NULL, NULL, '12.11', NULL, '2019-06-21 11:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (488, 2, 8561680384, 3869405184, 4692275200, '45.19', NULL, '2019-06-21 11:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (489, 1, NULL, NULL, NULL, '11.29', NULL, '2019-06-21 11:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (490, 2, 8561680384, 3875672064, 4686008320, '45.27', NULL, '2019-06-21 11:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (491, 1, NULL, NULL, NULL, '10.17', NULL, '2019-06-21 11:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (492, 2, 8561680384, 3890667520, 4671012864, '45.44', NULL, '2019-06-21 11:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (493, 1, NULL, NULL, NULL, '9.45', NULL, '2019-06-21 11:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (494, 2, 8561680384, 3847270400, 4714409984, '44.94', NULL, '2019-06-21 11:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (495, 1, NULL, NULL, NULL, '11.68', NULL, '2019-06-21 11:39:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (496, 2, 8561680384, 3847680000, 4714000384, '44.94', NULL, '2019-06-21 11:39:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (497, 1, NULL, NULL, NULL, '11.82', NULL, '2019-06-21 11:39:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (498, 2, 8561680384, 3840532480, 4721147904, '44.86', NULL, '2019-06-21 11:39:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (499, 1, NULL, NULL, NULL, '11.78', NULL, '2019-06-21 11:40:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (500, 2, 8561680384, 3835998208, 4725682176, '44.80', NULL, '2019-06-21 11:40:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (501, 1, NULL, NULL, NULL, '11.17', NULL, '2019-06-21 11:40:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (502, 2, 8561680384, 3837341696, 4724338688, '44.82', NULL, '2019-06-21 11:40:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (503, 1, NULL, NULL, NULL, '9.53', NULL, '2019-06-21 11:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (504, 2, 8561680384, 3832713216, 4728967168, '44.77', NULL, '2019-06-21 11:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (505, 1, NULL, NULL, NULL, '9.52', NULL, '2019-06-21 11:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (506, 2, 8561680384, 3830366208, 4731314176, '44.74', NULL, '2019-06-21 11:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (507, 1, NULL, NULL, NULL, '11.59', NULL, '2019-06-21 11:42:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (508, 2, 8561680384, 3818983424, 4742696960, '44.61', NULL, '2019-06-21 11:42:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (509, 1, NULL, NULL, NULL, '11.89', NULL, '2019-06-21 11:42:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (510, 2, 8561680384, 3818614784, 4743065600, '44.60', NULL, '2019-06-21 11:42:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (511, 1, NULL, NULL, NULL, '13.48', NULL, '2019-06-21 11:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (512, 2, 8561680384, 3819270144, 4742410240, '44.61', NULL, '2019-06-21 11:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (513, 1, NULL, NULL, NULL, '11.98', NULL, '2019-06-21 11:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (514, 2, 8561680384, 3821920256, 4739760128, '44.64', NULL, '2019-06-21 11:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (515, 1, NULL, NULL, NULL, '9.88', NULL, '2019-06-21 11:44:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (516, 2, 8561680384, 3825528832, 4736151552, '44.68', NULL, '2019-06-21 11:44:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (517, 1, NULL, NULL, NULL, '5.14', NULL, '2019-06-21 11:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (518, 2, 8416260096, 5837889536, 2578370560, '69.36', NULL, '2019-06-21 11:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (519, 1, NULL, NULL, NULL, '1.59', NULL, '2019-06-21 12:11:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (520, 2, 4163604480, 3817988096, 345616384, '91.70', NULL, '2019-06-21 12:11:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (521, 1, NULL, NULL, NULL, '55.24', NULL, '2019-06-21 12:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (522, 2, 4163604480, 3620417536, 543186944, '86.95', NULL, '2019-06-21 12:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (523, 1, NULL, NULL, NULL, '21.61', NULL, '2019-06-24 08:53:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (524, 2, 12762304512, 4672507904, 8089796608, '36.61', NULL, '2019-06-24 08:53:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (525, 1, NULL, NULL, NULL, '16.22', NULL, '2019-06-24 08:54:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (526, 2, 12762304512, 5011935232, 7750369280, '39.27', NULL, '2019-06-24 08:54:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (527, 1, NULL, NULL, NULL, '38.97', NULL, '2019-06-24 08:54:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (528, 2, 12762304512, 5257039872, 7505264640, '41.19', NULL, '2019-06-24 08:54:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (529, 1, NULL, NULL, NULL, '22.51', NULL, '2019-06-24 08:55:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (530, 2, 12762304512, 5262336000, 7499968512, '41.23', NULL, '2019-06-24 08:55:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (531, 1, NULL, NULL, NULL, '32.33', NULL, '2019-06-24 08:55:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (532, 2, 12762304512, 5807833088, 6954471424, '45.51', NULL, '2019-06-24 08:55:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (533, 1, NULL, NULL, NULL, '25.13', NULL, '2019-06-24 08:56:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (534, 2, 12762304512, 5690159104, 7072145408, '44.59', NULL, '2019-06-24 08:56:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (535, 1, NULL, NULL, NULL, '18.18', NULL, '2019-06-24 08:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (536, 2, 12762304512, 5690011648, 7072292864, '44.58', NULL, '2019-06-24 08:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (537, 1, NULL, NULL, NULL, '28.57', NULL, '2019-06-24 08:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (538, 2, 12762304512, 5785731072, 6976573440, '45.33', NULL, '2019-06-24 08:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (539, 1, NULL, NULL, NULL, '23.95', NULL, '2019-06-24 08:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (540, 2, 8447492096, 4951912448, 3495579648, '58.62', NULL, '2019-06-24 08:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (541, 1, NULL, NULL, NULL, '20.44', NULL, '2019-06-24 08:57:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (542, 2, 12762304512, 5472808960, 7289495552, '42.88', NULL, '2019-06-24 08:57:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (543, 1, NULL, NULL, NULL, '17.79', NULL, '2019-06-24 08:58:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (544, 2, 12762304512, 5533065216, 7229239296, '43.35', NULL, '2019-06-24 08:58:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (545, 1, NULL, NULL, NULL, '23.96', NULL, '2019-06-24 08:58:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (546, 2, 8447492096, 5021532160, 3425959936, '59.44', NULL, '2019-06-24 08:58:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (547, 1, NULL, NULL, NULL, '11.26', NULL, '2019-06-24 08:58:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (548, 2, 12762304512, 5535879168, 7226425344, '43.38', NULL, '2019-06-24 08:58:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (549, 1, NULL, NULL, NULL, '13.54', NULL, '2019-06-24 08:59:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (550, 2, 12762304512, 5584785408, 7177519104, '43.76', NULL, '2019-06-24 08:59:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (551, 1, NULL, NULL, NULL, '20.23', NULL, '2019-06-24 08:59:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (552, 2, 12762304512, 5675511808, 7086792704, '44.47', NULL, '2019-06-24 08:59:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (553, 1, NULL, NULL, NULL, '23.97', NULL, '2019-06-24 08:59:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (554, 2, 8447492096, 5070385152, 3377106944, '60.02', NULL, '2019-06-24 08:59:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (555, 1, NULL, NULL, NULL, '27.70', NULL, '2019-06-24 09:00:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (556, 2, 12762304512, 5873893376, 6888411136, '46.03', NULL, '2019-06-24 09:00:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (557, 1, NULL, NULL, NULL, '35.77', NULL, '2019-06-24 09:00:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (558, 2, 8447492096, 5352603648, 3094888448, '63.36', NULL, '2019-06-24 09:00:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (559, 1, NULL, NULL, NULL, '16.81', NULL, '2019-06-24 09:00:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (560, 2, 12762304512, 5860761600, 6901542912, '45.92', NULL, '2019-06-24 09:00:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (561, 1, NULL, NULL, NULL, '18.73', NULL, '2019-06-24 09:00:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (562, 2, 8447492096, 5286326272, 3161165824, '62.58', NULL, '2019-06-24 09:00:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (563, 1, NULL, NULL, NULL, '11.31', NULL, '2019-06-24 09:01:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (564, 2, 12762304512, 5827035136, 6935269376, '45.66', NULL, '2019-06-24 09:01:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (565, 1, NULL, NULL, NULL, '19.23', NULL, '2019-06-24 09:01:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (566, 2, 8447492096, 5291913216, 3155578880, '62.64', NULL, '2019-06-24 09:01:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (567, 1, NULL, NULL, NULL, '15.06', NULL, '2019-06-24 09:01:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (568, 2, 12762304512, 5845651456, 6916653056, '45.80', NULL, '2019-06-24 09:01:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (569, 1, NULL, NULL, NULL, '24.97', NULL, '2019-06-24 09:01:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (570, 2, 8447492096, 5312978944, 3134513152, '62.89', NULL, '2019-06-24 09:01:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (571, 1, NULL, NULL, NULL, '15.09', NULL, '2019-06-24 09:02:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (572, 2, 12762304512, 5857943552, 6904360960, '45.90', NULL, '2019-06-24 09:02:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (573, 1, NULL, NULL, NULL, '25.35', NULL, '2019-06-24 09:02:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (574, 2, 8447492096, 5294301184, 3153190912, '62.67', NULL, '2019-06-24 09:02:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (575, 1, NULL, NULL, NULL, '13.81', NULL, '2019-06-24 09:02:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (576, 2, 12762304512, 5832249344, 6930055168, '45.70', NULL, '2019-06-24 09:02:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (577, 1, NULL, NULL, NULL, '21.89', NULL, '2019-06-24 09:02:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (578, 2, 8447492096, 5307301888, 3140190208, '62.83', NULL, '2019-06-24 09:02:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (579, 1, NULL, NULL, NULL, '29.69', NULL, '2019-06-24 09:03:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (580, 2, 12762304512, 6444052480, 6318252032, '50.49', NULL, '2019-06-24 09:03:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (581, 1, NULL, NULL, NULL, '18.45', NULL, '2019-06-24 09:03:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (582, 2, 8447492096, 5248536576, 3198955520, '62.13', NULL, '2019-06-24 09:03:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (583, 1, NULL, NULL, NULL, '17.07', NULL, '2019-06-24 09:03:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (584, 2, 12762304512, 6029664256, 6732640256, '47.25', NULL, '2019-06-24 09:03:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (585, 1, NULL, NULL, NULL, '14.91', NULL, '2019-06-24 09:03:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (586, 2, 8447492096, 5170663424, 3276828672, '61.21', NULL, '2019-06-24 09:03:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (587, 1, NULL, NULL, NULL, '17.06', NULL, '2019-06-24 09:04:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (588, 2, 12762304512, 6025592832, 6736711680, '47.21', NULL, '2019-06-24 09:04:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (589, 1, NULL, NULL, NULL, '16.97', NULL, '2019-06-24 09:04:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (590, 2, 8447492096, 5115162624, 3332329472, '60.55', NULL, '2019-06-24 09:04:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (591, 1, NULL, NULL, NULL, '18.23', NULL, '2019-06-24 09:04:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (592, 2, 12762304512, 6056296448, 6706008064, '47.45', NULL, '2019-06-24 09:04:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (593, 1, NULL, NULL, NULL, '18.85', NULL, '2019-06-24 09:04:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (594, 2, 8447492096, 5082943488, 3364548608, '60.17', NULL, '2019-06-24 09:04:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (595, 1, NULL, NULL, NULL, '16.45', NULL, '2019-06-24 09:05:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (596, 2, 12762304512, 6118072320, 6644232192, '47.94', NULL, '2019-06-24 09:05:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (597, 1, NULL, NULL, NULL, '15.14', NULL, '2019-06-24 09:05:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (598, 2, 8447492096, 5045727232, 3401764864, '59.73', NULL, '2019-06-24 09:05:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (599, 1, NULL, NULL, NULL, '17.81', NULL, '2019-06-24 09:05:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (600, 2, 12762304512, 6161944576, 6600359936, '48.28', NULL, '2019-06-24 09:05:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (601, 1, NULL, NULL, NULL, '20.04', NULL, '2019-06-24 09:05:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (602, 2, 8447492096, 5168840704, 3278651392, '61.19', NULL, '2019-06-24 09:05:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (603, 1, NULL, NULL, NULL, '13.72', NULL, '2019-06-24 09:06:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (604, 2, 12762304512, 6153773056, 6608531456, '48.22', NULL, '2019-06-24 09:06:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (605, 1, NULL, NULL, NULL, '23.49', NULL, '2019-06-24 09:06:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (606, 2, 8447492096, 5027958784, 3419533312, '59.52', NULL, '2019-06-24 09:06:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (607, 1, NULL, NULL, NULL, '15.63', NULL, '2019-06-24 09:06:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (608, 2, 12762304512, 6204420096, 6557884416, '48.62', NULL, '2019-06-24 09:06:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (609, 1, NULL, NULL, NULL, '21.04', NULL, '2019-06-24 09:06:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (610, 2, 8447492096, 5091291136, 3356200960, '60.27', NULL, '2019-06-24 09:06:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (611, 1, NULL, NULL, NULL, '18.44', NULL, '2019-06-24 09:07:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (612, 2, 12762304512, 6192136192, 6570168320, '48.52', NULL, '2019-06-24 09:07:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (613, 1, NULL, NULL, NULL, '26.12', NULL, '2019-06-24 09:07:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (614, 2, 8447492096, 5025992704, 3421499392, '59.50', NULL, '2019-06-24 09:07:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (615, 1, NULL, NULL, NULL, '16.31', NULL, '2019-06-24 09:07:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (616, 2, 12762304512, 6161940480, 6600364032, '48.28', NULL, '2019-06-24 09:07:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (617, 1, NULL, NULL, NULL, '42.21', NULL, '2019-06-24 09:07:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (618, 2, 8447492096, 5313052672, 3134439424, '62.90', NULL, '2019-06-24 09:07:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (619, 1, NULL, NULL, NULL, '16.22', NULL, '2019-06-24 09:08:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (620, 2, 12762304512, 6164185088, 6598119424, '48.30', NULL, '2019-06-24 09:08:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (621, 1, NULL, NULL, NULL, '34.49', NULL, '2019-06-24 09:08:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (622, 2, 8447492096, 5400440832, 3047051264, '63.93', NULL, '2019-06-24 09:08:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (623, 1, NULL, NULL, NULL, '14.47', NULL, '2019-06-24 09:08:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (624, 2, 12762304512, 6152495104, 6609809408, '48.21', NULL, '2019-06-24 09:08:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (625, 1, NULL, NULL, NULL, '33.37', NULL, '2019-06-24 09:08:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (626, 2, 8447492096, 5429420032, 3018072064, '64.27', NULL, '2019-06-24 09:08:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (627, 1, NULL, NULL, NULL, '16.89', NULL, '2019-06-24 09:09:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (628, 2, 12762304512, 6138085376, 6624219136, '48.10', NULL, '2019-06-24 09:09:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (629, 1, NULL, NULL, NULL, '34.84', NULL, '2019-06-24 09:09:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (630, 2, 8447492096, 5424250880, 3023241216, '64.21', NULL, '2019-06-24 09:09:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (631, 1, NULL, NULL, NULL, '12.76', NULL, '2019-06-24 09:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (632, 2, 12762304512, 6109548544, 6652755968, '47.87', NULL, '2019-06-24 09:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (633, 1, NULL, NULL, NULL, '25.12', NULL, '2019-06-24 09:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (634, 2, 8447492096, 5467881472, 2979610624, '64.73', NULL, '2019-06-24 09:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (635, 1, NULL, NULL, NULL, '12.89', NULL, '2019-06-24 09:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (636, 2, 12762304512, 6107750400, 6654554112, '47.86', NULL, '2019-06-24 09:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (637, 1, NULL, NULL, NULL, '30.78', NULL, '2019-06-24 09:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (638, 2, 8447492096, 5492072448, 2955419648, '65.01', NULL, '2019-06-24 09:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (639, 1, NULL, NULL, NULL, '15.91', NULL, '2019-06-24 09:10:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (640, 2, 12762304512, 6120415232, 6641889280, '47.96', NULL, '2019-06-24 09:10:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (641, 1, NULL, NULL, NULL, '13.42', NULL, '2019-06-24 09:11:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (642, 2, 12762304512, 6112567296, 6649737216, '47.90', NULL, '2019-06-24 09:11:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (643, 1, NULL, NULL, NULL, '26.86', NULL, '2019-06-24 09:10:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (644, 2, 8447492096, 5505675264, 2941816832, '65.18', NULL, '2019-06-24 09:10:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (645, 1, NULL, NULL, NULL, '13.23', NULL, '2019-06-24 09:11:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (646, 2, 12762304512, 6137049088, 6625255424, '48.09', NULL, '2019-06-24 09:11:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (647, 1, NULL, NULL, NULL, '39.78', NULL, '2019-06-24 09:11:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (648, 2, 8447492096, 5529432064, 2918060032, '65.46', NULL, '2019-06-24 09:11:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (649, 1, NULL, NULL, NULL, '28.31', NULL, '2019-06-24 09:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (650, 2, 12762304512, 6033084416, 6729220096, '47.27', NULL, '2019-06-24 09:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (651, 1, NULL, NULL, NULL, '47.33', NULL, '2019-06-24 09:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (652, 2, 8447492096, 5451493376, 2995998720, '64.53', NULL, '2019-06-24 09:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (653, 1, NULL, NULL, NULL, '20.34', NULL, '2019-06-24 09:12:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (654, 2, 12762304512, 6187569152, 6574735360, '48.48', NULL, '2019-06-24 09:12:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (655, 1, NULL, NULL, NULL, '47.21', NULL, '2019-06-24 09:12:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (656, 2, 8447492096, 5502128128, 2945363968, '65.13', NULL, '2019-06-24 09:12:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (657, 1, NULL, NULL, NULL, '17.29', NULL, '2019-06-24 09:13:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (658, 2, 12762304512, 6168395776, 6593908736, '48.33', NULL, '2019-06-24 09:13:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (659, 1, NULL, NULL, NULL, '29.22', NULL, '2019-06-24 09:13:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (660, 2, 8447492096, 5504045056, 2943447040, '65.16', NULL, '2019-06-24 09:13:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (661, 1, NULL, NULL, NULL, '13.06', NULL, '2019-06-24 09:13:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (662, 2, 12762304512, 6156111872, 6606192640, '48.24', NULL, '2019-06-24 09:13:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (663, 1, NULL, NULL, NULL, '29.39', NULL, '2019-06-24 09:13:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (664, 2, 8447492096, 5486579712, 2960912384, '64.95', NULL, '2019-06-24 09:13:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (665, 1, NULL, NULL, NULL, '17.42', NULL, '2019-06-24 09:14:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (666, 2, 12762304512, 6199627776, 6562676736, '48.58', NULL, '2019-06-24 09:14:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (667, 1, NULL, NULL, NULL, '33.53', NULL, '2019-06-24 09:14:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (668, 2, 8447492096, 5530931200, 2916560896, '65.47', NULL, '2019-06-24 09:14:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (669, 1, NULL, NULL, NULL, '18.80', NULL, '2019-06-24 09:14:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (670, 2, 12762304512, 6321930240, 6440374272, '49.54', NULL, '2019-06-24 09:14:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (671, 1, NULL, NULL, NULL, '28.55', NULL, '2019-06-24 09:14:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (672, 2, 8447492096, 5518929920, 2928562176, '65.33', NULL, '2019-06-24 09:14:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (673, 1, NULL, NULL, NULL, '12.16', NULL, '2019-06-24 09:15:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (674, 2, 12762304512, 6278836224, 6483468288, '49.20', NULL, '2019-06-24 09:15:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (675, 1, NULL, NULL, NULL, '41.44', NULL, '2019-06-24 09:15:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (676, 2, 8447492096, 5541658624, 2905833472, '65.60', NULL, '2019-06-24 09:15:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (677, 1, NULL, NULL, NULL, '17.73', NULL, '2019-06-24 09:15:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (678, 2, 12762304512, 6308012032, 6454292480, '49.43', NULL, '2019-06-24 09:15:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (679, 1, NULL, NULL, NULL, '40.89', NULL, '2019-06-24 09:15:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (680, 2, 8447492096, 5520240640, 2927251456, '65.35', NULL, '2019-06-24 09:15:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (681, 1, NULL, NULL, NULL, '18.87', NULL, '2019-06-24 09:16:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (682, 2, 12762304512, 6407917568, 6354386944, '50.21', NULL, '2019-06-24 09:16:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (683, 1, NULL, NULL, NULL, '27.29', NULL, '2019-06-24 09:16:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (684, 2, 8447492096, 5619806208, 2827685888, '66.53', NULL, '2019-06-24 09:16:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (685, 1, NULL, NULL, NULL, '15.07', NULL, '2019-06-24 09:16:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (686, 2, 12762304512, 6354051072, 6408253440, '49.79', NULL, '2019-06-24 09:16:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (687, 1, NULL, NULL, NULL, '46.05', NULL, '2019-06-24 09:16:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (688, 2, 8447492096, 5576978432, 2870513664, '66.02', NULL, '2019-06-24 09:16:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (689, 1, NULL, NULL, NULL, '19.10', NULL, '2019-06-24 09:17:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (690, 2, 12762304512, 5963866112, 6798438400, '46.73', NULL, '2019-06-24 09:17:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (691, 1, NULL, NULL, NULL, '47.47', NULL, '2019-06-24 09:17:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (692, 2, 8447492096, 4771704832, 3675787264, '56.49', NULL, '2019-06-24 09:17:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (693, 1, NULL, NULL, NULL, '19.82', NULL, '2019-06-24 09:17:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (694, 2, 12762304512, 5905715200, 6856589312, '46.27', NULL, '2019-06-24 09:17:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (695, 1, NULL, NULL, NULL, '25.77', NULL, '2019-06-24 09:17:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (696, 2, 8447492096, 4844892160, 3602599936, '57.35', NULL, '2019-06-24 09:17:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (697, 1, NULL, NULL, NULL, '14.44', NULL, '2019-06-24 09:18:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (698, 2, 12762304512, 5887782912, 6874521600, '46.13', NULL, '2019-06-24 09:18:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (699, 1, NULL, NULL, NULL, '19.97', NULL, '2019-06-24 09:18:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (700, 2, 8447492096, 4839133184, 3608358912, '57.28', NULL, '2019-06-24 09:18:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (701, 1, NULL, NULL, NULL, '17.03', NULL, '2019-06-24 09:18:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (702, 2, 12762304512, 5927677952, 6834626560, '46.45', NULL, '2019-06-24 09:18:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (703, 1, NULL, NULL, NULL, '24.15', NULL, '2019-06-24 09:18:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (704, 2, 8447492096, 4831182848, 3616309248, '57.19', NULL, '2019-06-24 09:18:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (705, 1, NULL, NULL, NULL, '14.71', NULL, '2019-06-24 09:19:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (706, 2, 12762304512, 5933891584, 6828412928, '46.50', NULL, '2019-06-24 09:19:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (707, 1, NULL, NULL, NULL, '15.79', NULL, '2019-06-24 09:19:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (708, 2, 8447492096, 4796952576, 3650539520, '56.79', NULL, '2019-06-24 09:19:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (709, 1, NULL, NULL, NULL, '19.56', NULL, '2019-06-24 09:19:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (710, 2, 12762304512, 6043435008, 6718869504, '47.35', NULL, '2019-06-24 09:19:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (711, 1, NULL, NULL, NULL, '16.80', NULL, '2019-06-24 09:19:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (712, 2, 8447492096, 4829007872, 3618484224, '57.16', NULL, '2019-06-24 09:19:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (713, 1, NULL, NULL, NULL, '15.95', NULL, '2019-06-24 09:20:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (714, 2, 12762304512, 5961809920, 6800494592, '46.71', NULL, '2019-06-24 09:20:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (715, 1, NULL, NULL, NULL, '15.90', NULL, '2019-06-24 09:20:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (716, 2, 8447492096, 4817440768, 3630051328, '57.03', NULL, '2019-06-24 09:20:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (717, 1, NULL, NULL, NULL, '16.90', NULL, '2019-06-24 09:20:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (718, 2, 12762304512, 6006460416, 6755844096, '47.06', NULL, '2019-06-24 09:20:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (719, 1, NULL, NULL, NULL, '9.91', NULL, '2019-06-24 09:20:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (720, 2, 8447492096, 4814336000, 3633156096, '56.99', NULL, '2019-06-24 09:20:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (721, 1, NULL, NULL, NULL, '17.29', NULL, '2019-06-24 09:21:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (722, 2, 12762304512, 5970104320, 6792200192, '46.78', NULL, '2019-06-24 09:21:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (723, 1, NULL, NULL, NULL, '14.57', NULL, '2019-06-24 09:21:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (724, 2, 8447492096, 4823052288, 3624439808, '57.09', NULL, '2019-06-24 09:21:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (725, 1, NULL, NULL, NULL, '20.20', NULL, '2019-06-24 09:21:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (726, 2, 12762304512, 5979447296, 6782857216, '46.85', NULL, '2019-06-24 09:21:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (727, 1, NULL, NULL, NULL, '24.38', NULL, '2019-06-24 09:21:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (728, 2, 8447492096, 4884897792, 3562594304, '57.83', NULL, '2019-06-24 09:21:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (729, 1, NULL, NULL, NULL, '14.82', NULL, '2019-06-24 09:22:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (730, 2, 12762304512, 5907464192, 6854840320, '46.29', NULL, '2019-06-24 09:22:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (731, 1, NULL, NULL, NULL, '41.57', NULL, '2019-06-24 09:22:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (732, 2, 8447492096, 5259456512, 3188035584, '62.26', NULL, '2019-06-24 09:22:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (733, 1, NULL, NULL, NULL, '17.32', NULL, '2019-06-24 09:22:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (734, 2, 12762304512, 6032363520, 6729940992, '47.27', NULL, '2019-06-24 09:22:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (735, 1, NULL, NULL, NULL, '18.32', NULL, '2019-06-24 09:23:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (736, 2, 12762304512, 5909446656, 6852857856, '46.30', NULL, '2019-06-24 09:23:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (737, 1, NULL, NULL, NULL, '22.81', NULL, '2019-06-24 09:23:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (738, 2, 12762304512, 6235447296, 6526857216, '48.86', NULL, '2019-06-24 09:23:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (739, 1, NULL, NULL, NULL, '15.44', NULL, '2019-06-24 09:24:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (740, 2, 12762304512, 6201688064, 6560616448, '48.59', NULL, '2019-06-24 09:24:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (741, 1, NULL, NULL, NULL, '24.01', NULL, '2019-06-24 09:24:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (742, 2, 8447492096, 5646737408, 2800754688, '66.85', NULL, '2019-06-24 09:24:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (743, 1, NULL, NULL, NULL, '13.45', NULL, '2019-06-24 09:24:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (744, 2, 12762304512, 6184910848, 6577393664, '48.46', NULL, '2019-06-24 09:24:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (745, 1, NULL, NULL, NULL, '40.39', NULL, '2019-06-24 09:24:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (746, 2, 8447492096, 5789437952, 2658054144, '68.53', NULL, '2019-06-24 09:24:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (747, 1, NULL, NULL, NULL, '13.49', NULL, '2019-06-24 09:25:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (748, 2, 12762304512, 6194061312, 6568243200, '48.53', NULL, '2019-06-24 09:25:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (749, 1, NULL, NULL, NULL, '28.33', NULL, '2019-06-24 09:25:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (750, 2, 8447492096, 5705134080, 2742358016, '67.54', NULL, '2019-06-24 09:25:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (751, 1, NULL, NULL, NULL, '14.66', NULL, '2019-06-24 09:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (752, 2, 12762304512, 6197432320, 6564872192, '48.56', NULL, '2019-06-24 09:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (753, 1, NULL, NULL, NULL, '33.39', NULL, '2019-06-24 09:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (754, 2, 8447492096, 6135439360, 2312052736, '72.63', NULL, '2019-06-24 09:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (755, 1, NULL, NULL, NULL, '14.06', NULL, '2019-06-24 09:26:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (756, 2, 12762304512, 6191370240, 6570934272, '48.51', NULL, '2019-06-24 09:26:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (757, 1, NULL, NULL, NULL, '24.38', NULL, '2019-06-24 09:26:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (758, 2, 8447492096, 6194253824, 2253238272, '73.33', NULL, '2019-06-24 09:26:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (759, 1, NULL, NULL, NULL, '13.87', NULL, '2019-06-24 09:26:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (760, 2, 12762304512, 6170718208, 6591586304, '48.35', NULL, '2019-06-24 09:26:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (761, 1, NULL, NULL, NULL, '28.45', NULL, '2019-06-24 09:26:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (762, 2, 8447492096, 6238334976, 2209157120, '73.85', NULL, '2019-06-24 09:26:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (763, 1, NULL, NULL, NULL, '12.93', NULL, '2019-06-24 09:27:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (764, 2, 12762304512, 6150336512, 6611968000, '48.19', NULL, '2019-06-24 09:27:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (765, 1, NULL, NULL, NULL, '23.44', NULL, '2019-06-24 09:27:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (766, 2, 8447492096, 6185668608, 2261823488, '73.22', NULL, '2019-06-24 09:27:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (767, 1, NULL, NULL, NULL, '16.91', NULL, '2019-06-24 09:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (768, 2, 12762304512, 6119772160, 6642532352, '47.95', NULL, '2019-06-24 09:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (769, 1, NULL, NULL, NULL, '24.24', NULL, '2019-06-24 09:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (770, 2, 8447492096, 6225010688, 2222481408, '73.69', NULL, '2019-06-24 09:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (771, 1, NULL, NULL, NULL, '10.86', NULL, '2019-06-24 09:28:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (772, 2, 12762304512, 6099283968, 6663020544, '47.79', NULL, '2019-06-24 09:28:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (773, 1, NULL, NULL, NULL, '36.24', NULL, '2019-06-24 09:28:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (774, 2, 8447492096, 6335098880, 2112393216, '74.99', NULL, '2019-06-24 09:28:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (775, 1, NULL, NULL, NULL, '10.40', NULL, '2019-06-24 09:28:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (776, 2, 12762304512, 6082011136, 6680293376, '47.66', NULL, '2019-06-24 09:28:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (777, 1, NULL, NULL, NULL, '19.15', NULL, '2019-06-24 09:28:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (778, 2, 8447492096, 6226960384, 2220531712, '73.71', NULL, '2019-06-24 09:28:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (779, 1, NULL, NULL, NULL, '15.09', NULL, '2019-06-24 09:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (780, 2, 12762304512, 6100676608, 6661627904, '47.80', NULL, '2019-06-24 09:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (781, 1, NULL, NULL, NULL, '15.26', NULL, '2019-06-24 09:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (782, 2, 8447492096, 6190182400, 2257309696, '73.28', NULL, '2019-06-24 09:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (783, 1, NULL, NULL, NULL, '12.92', NULL, '2019-06-24 09:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (784, 2, 12762304512, 6112256000, 6650048512, '47.89', NULL, '2019-06-24 09:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (785, 1, NULL, NULL, NULL, '12.46', NULL, '2019-06-24 09:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (786, 2, 8447492096, 6158438400, 2289053696, '72.90', NULL, '2019-06-24 09:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (787, 1, NULL, NULL, NULL, '13.42', NULL, '2019-06-24 09:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (788, 2, 12762304512, 6088077312, 6674227200, '47.70', NULL, '2019-06-24 09:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (789, 1, NULL, NULL, NULL, '32.84', NULL, '2019-06-24 09:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (790, 2, 8447492096, 6295986176, 2151505920, '74.53', NULL, '2019-06-24 09:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (791, 1, NULL, NULL, NULL, '14.54', NULL, '2019-06-24 09:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (792, 2, 12762304512, 6093185024, 6669119488, '47.74', NULL, '2019-06-24 09:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (793, 1, NULL, NULL, NULL, '28.57', NULL, '2019-06-24 09:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (794, 2, 8447492096, 6314078208, 2133413888, '74.75', NULL, '2019-06-24 09:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (795, 1, NULL, NULL, NULL, '14.56', NULL, '2019-06-24 09:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (796, 2, 12762304512, 6074368000, 6687936512, '47.60', NULL, '2019-06-24 09:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (797, 1, NULL, NULL, NULL, '28.58', NULL, '2019-06-24 09:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (798, 2, 8447492096, 6324781056, 2122711040, '74.87', NULL, '2019-06-24 09:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (799, 1, NULL, NULL, NULL, '14.65', NULL, '2019-06-24 09:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (800, 2, 12762304512, 6066786304, 6695518208, '47.54', NULL, '2019-06-24 09:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (801, 1, NULL, NULL, NULL, '31.12', NULL, '2019-06-24 09:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (802, 2, 8447492096, 6509031424, 1938460672, '77.05', NULL, '2019-06-24 09:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (803, 1, NULL, NULL, NULL, '14.75', NULL, '2019-06-24 09:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (804, 2, 12762304512, 6066413568, 6695890944, '47.53', NULL, '2019-06-24 09:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (805, 1, NULL, NULL, NULL, '31.14', NULL, '2019-06-24 09:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (806, 2, 8447492096, 6509961216, 1937530880, '77.06', NULL, '2019-06-24 09:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (807, 1, NULL, NULL, NULL, '14.74', NULL, '2019-06-24 09:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (808, 2, 12762304512, 6049075200, 6713229312, '47.40', NULL, '2019-06-24 09:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (809, 1, NULL, NULL, NULL, '31.41', NULL, '2019-06-24 09:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (810, 2, 8447492096, 6493106176, 1954385920, '76.86', NULL, '2019-06-24 09:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (811, 1, NULL, NULL, NULL, '18.01', NULL, '2019-06-24 09:33:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (812, 2, 12762304512, 6069891072, 6692413440, '47.56', NULL, '2019-06-24 09:33:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (813, 1, NULL, NULL, NULL, '22.24', NULL, '2019-06-24 09:33:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (814, 2, 8447492096, 6440067072, 2007425024, '76.24', NULL, '2019-06-24 09:33:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (815, 1, NULL, NULL, NULL, '22.56', NULL, '2019-06-24 09:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (816, 2, 12762304512, 6032023552, 6730280960, '47.26', NULL, '2019-06-24 09:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (817, 1, NULL, NULL, NULL, '39.23', NULL, '2019-06-24 09:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (818, 2, 8447492096, 6699671552, 1747820544, '79.31', NULL, '2019-06-24 09:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (819, 1, NULL, NULL, NULL, '18.44', NULL, '2019-06-24 09:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (820, 2, 12762304512, 6091603968, 6670700544, '47.73', NULL, '2019-06-24 09:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (821, 1, NULL, NULL, NULL, '25.30', NULL, '2019-06-24 09:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (822, 2, 8447492096, 6679351296, 1768140800, '79.07', NULL, '2019-06-24 09:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (823, 1, NULL, NULL, NULL, '18.06', NULL, '2019-06-24 09:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (824, 2, 12762304512, 6112264192, 6650040320, '47.89', NULL, '2019-06-24 09:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (825, 1, NULL, NULL, NULL, '14.15', NULL, '2019-06-24 09:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (826, 2, 8447492096, 6643687424, 1803804672, '78.65', NULL, '2019-06-24 09:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (827, 1, NULL, NULL, NULL, '17.15', NULL, '2019-06-24 09:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (828, 2, 12762304512, 6121316352, 6640988160, '47.96', NULL, '2019-06-24 09:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (829, 1, NULL, NULL, NULL, '14.87', NULL, '2019-06-24 09:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (830, 2, 8447492096, 6621655040, 1825837056, '78.39', NULL, '2019-06-24 09:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (831, 1, NULL, NULL, NULL, '21.04', NULL, '2019-06-24 09:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (832, 2, 12762304512, 6092230656, 6670073856, '47.74', NULL, '2019-06-24 09:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (833, 1, NULL, NULL, NULL, '13.18', NULL, '2019-06-24 09:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (834, 2, 8447492096, 6584320000, 1863172096, '77.94', NULL, '2019-06-24 09:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (835, 1, NULL, NULL, NULL, '14.06', NULL, '2019-06-24 09:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (836, 2, 12762304512, 6092574720, 6669729792, '47.74', NULL, '2019-06-24 09:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (837, 1, NULL, NULL, NULL, '12.02', NULL, '2019-06-24 09:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (838, 2, 8447492096, 6573936640, 1873555456, '77.82', NULL, '2019-06-24 09:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (839, 1, NULL, NULL, NULL, '15.72', NULL, '2019-06-24 09:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (840, 2, 12762304512, 6084169728, 6678134784, '47.67', NULL, '2019-06-24 09:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (841, 1, NULL, NULL, NULL, '14.99', NULL, '2019-06-24 09:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (842, 2, 8447492096, 6681862144, 1765629952, '79.10', NULL, '2019-06-24 09:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (843, 1, NULL, NULL, NULL, '23.18', NULL, '2019-06-24 09:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (844, 2, 8447492096, 6442450944, 2005041152, '76.26', NULL, '2019-06-24 09:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (845, 1, NULL, NULL, NULL, '20.31', NULL, '2019-06-24 09:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (846, 2, 8447492096, 6453977088, 1993515008, '76.40', NULL, '2019-06-24 09:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (847, 1, NULL, NULL, NULL, '22.83', NULL, '2019-06-24 09:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (848, 2, 8447492096, 6515494912, 1931997184, '77.13', NULL, '2019-06-24 09:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (849, 1, NULL, NULL, NULL, '20.74', NULL, '2019-06-24 09:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (850, 2, 8447492096, 6500855808, 1946636288, '76.96', NULL, '2019-06-24 09:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (851, 1, NULL, NULL, NULL, '21.13', NULL, '2019-06-24 09:39:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (852, 2, 8447492096, 6498893824, 1948598272, '76.93', NULL, '2019-06-24 09:39:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (853, 1, NULL, NULL, NULL, '17.50', NULL, '2019-06-24 09:39:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (854, 2, 8447492096, 6499622912, 1947869184, '76.94', NULL, '2019-06-24 09:39:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (855, 1, NULL, NULL, NULL, '20.09', NULL, '2019-06-24 09:40:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (856, 2, 8447492096, 6691840000, 1755652096, '79.22', NULL, '2019-06-24 09:40:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (857, 1, NULL, NULL, NULL, '50.40', NULL, '2019-06-24 09:40:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (858, 2, 8447492096, 6823710720, 1623781376, '80.78', NULL, '2019-06-24 09:40:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (859, 1, NULL, NULL, NULL, '30.35', NULL, '2019-06-24 09:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (860, 2, 8447492096, 6902046720, 1545445376, '81.71', NULL, '2019-06-24 09:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (861, 1, NULL, NULL, NULL, '39.56', NULL, '2019-06-24 09:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (862, 2, 8447492096, 7025455104, 1422036992, '83.17', NULL, '2019-06-24 09:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (863, 1, NULL, NULL, NULL, '32.17', NULL, '2019-06-24 09:42:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (864, 2, 8447492096, 6846255104, 1601236992, '81.04', NULL, '2019-06-24 09:42:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (865, 1, NULL, NULL, NULL, '41.33', NULL, '2019-06-24 09:42:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (866, 2, 8447492096, 6592864256, 1854627840, '78.05', NULL, '2019-06-24 09:42:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (867, 1, NULL, NULL, NULL, '39.78', NULL, '2019-06-24 09:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (868, 2, 8447492096, 6809731072, 1637761024, '80.61', NULL, '2019-06-24 09:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (869, 1, NULL, NULL, NULL, '37.51', NULL, '2019-06-24 09:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (870, 2, 8447492096, 6845546496, 1601945600, '81.04', NULL, '2019-06-24 09:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (871, 1, NULL, NULL, NULL, '38.31', NULL, '2019-06-24 09:44:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (872, 2, 8447492096, 6793056256, 1654435840, '80.42', NULL, '2019-06-24 09:44:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (873, 1, NULL, NULL, NULL, '25.10', NULL, '2019-06-24 09:44:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (874, 2, 8447492096, 6696415232, 1751076864, '79.27', NULL, '2019-06-24 09:44:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (875, 1, NULL, NULL, NULL, '19.09', NULL, '2019-06-24 09:45:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (876, 2, 8447492096, 6674898944, 1772593152, '79.02', NULL, '2019-06-24 09:45:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (877, 1, NULL, NULL, NULL, '18.19', NULL, '2019-06-24 09:45:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (878, 2, 8447492096, 6663946240, 1783545856, '78.89', NULL, '2019-06-24 09:45:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (879, 1, NULL, NULL, NULL, '26.99', NULL, '2019-06-24 09:46:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (880, 2, 8447492096, 6661849088, 1785643008, '78.86', NULL, '2019-06-24 09:46:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (881, 1, NULL, NULL, NULL, '37.05', NULL, '2019-06-24 09:46:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (882, 2, 8447492096, 6630490112, 1817001984, '78.49', NULL, '2019-06-24 09:46:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (883, 1, NULL, NULL, NULL, '29.45', NULL, '2019-06-24 09:47:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (884, 2, 8447492096, 4767514624, 3679977472, '56.44', NULL, '2019-06-24 09:47:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (885, 1, NULL, NULL, NULL, '48.03', NULL, '2019-06-24 09:47:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (886, 2, 8447492096, 4294848512, 4152643584, '50.84', NULL, '2019-06-24 09:47:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (887, 1, NULL, NULL, NULL, '38.67', NULL, '2019-06-24 09:48:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (888, 2, 8447492096, 4618838016, 3828654080, '54.68', NULL, '2019-06-24 09:48:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (889, 1, NULL, NULL, NULL, '24.94', NULL, '2019-06-24 09:48:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (890, 2, 8447492096, 4591763456, 3855728640, '54.36', NULL, '2019-06-24 09:48:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (891, 1, NULL, NULL, NULL, '17.76', NULL, '2019-06-24 09:49:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (892, 2, 8447492096, 4580696064, 3866796032, '54.23', NULL, '2019-06-24 09:49:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (893, 1, NULL, NULL, NULL, '31.90', NULL, '2019-06-24 09:49:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (894, 2, 8447492096, 4624691200, 3822800896, '54.75', NULL, '2019-06-24 09:49:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (895, 1, NULL, NULL, NULL, '39.13', NULL, '2019-06-24 09:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (896, 2, 8447492096, 4612808704, 3834683392, '54.61', NULL, '2019-06-24 09:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (897, 1, NULL, NULL, NULL, '31.59', NULL, '2019-06-24 09:50:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (898, 2, 8447492096, 4673003520, 3774488576, '55.32', NULL, '2019-06-24 09:50:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (899, 1, NULL, NULL, NULL, '32.03', NULL, '2019-06-24 09:51:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (900, 2, 8447492096, 4714455040, 3733037056, '55.81', NULL, '2019-06-24 09:51:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (901, 1, NULL, NULL, NULL, '42.64', NULL, '2019-06-24 09:51:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (902, 2, 8447492096, 4807417856, 3640074240, '56.91', NULL, '2019-06-24 09:51:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (903, 1, NULL, NULL, NULL, '31.55', NULL, '2019-06-24 09:52:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (904, 2, 8447492096, 4785430528, 3662061568, '56.65', NULL, '2019-06-24 09:52:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (905, 1, NULL, NULL, NULL, '28.42', NULL, '2019-06-24 09:52:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (906, 2, 8447492096, 4819021824, 3628470272, '57.05', NULL, '2019-06-24 09:52:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (907, 1, NULL, NULL, NULL, '33.99', NULL, '2019-06-24 09:53:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (908, 2, 8447492096, 4844204032, 3603288064, '57.34', NULL, '2019-06-24 09:53:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (909, 1, NULL, NULL, NULL, '32.21', NULL, '2019-06-24 09:53:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (910, 2, 8447492096, 4859088896, 3588403200, '57.52', NULL, '2019-06-24 09:53:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (911, 1, NULL, NULL, NULL, '31.87', NULL, '2019-06-24 09:54:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (912, 2, 8447492096, 4967161856, 3480330240, '58.80', NULL, '2019-06-24 09:54:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (913, 1, NULL, NULL, NULL, '31.24', NULL, '2019-06-24 09:54:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (914, 2, 8447492096, 5066489856, 3381002240, '59.98', NULL, '2019-06-24 09:54:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (915, 1, NULL, NULL, NULL, '26.15', NULL, '2019-06-24 09:55:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (916, 2, 8447492096, 5041778688, 3405713408, '59.68', NULL, '2019-06-24 09:55:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (917, 1, NULL, NULL, NULL, '49.84', NULL, '2019-06-24 09:55:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (918, 2, 8447492096, 5151473664, 3296018432, '60.98', NULL, '2019-06-24 09:55:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (919, 1, NULL, NULL, NULL, '28.40', NULL, '2019-06-24 09:56:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (920, 2, 8447492096, 5134860288, 3312631808, '60.79', NULL, '2019-06-24 09:56:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (921, 1, NULL, NULL, NULL, '30.78', NULL, '2019-06-24 09:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (922, 2, 8447492096, 5072703488, 3374788608, '60.05', NULL, '2019-06-24 09:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (923, 1, NULL, NULL, NULL, '44.65', NULL, '2019-06-24 09:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (924, 2, 8447492096, 5277532160, 3169959936, '62.47', NULL, '2019-06-24 09:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (925, 1, NULL, NULL, NULL, '33.45', NULL, '2019-06-24 09:57:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (926, 2, 8447492096, 5243277312, 3204214784, '62.07', NULL, '2019-06-24 09:57:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (927, 1, NULL, NULL, NULL, '28.57', NULL, '2019-06-24 09:58:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (928, 2, 8447492096, 4951552000, 3495940096, '58.62', NULL, '2019-06-24 09:58:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (929, 1, NULL, NULL, NULL, '33.78', NULL, '2019-06-24 10:00:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (930, 2, 8447492096, 4997619712, 3449872384, '59.16', NULL, '2019-06-24 10:00:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (931, 1, NULL, NULL, NULL, '22.50', NULL, '2019-06-24 10:00:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (932, 2, 8447492096, 4956442624, 3491049472, '58.67', NULL, '2019-06-24 10:00:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (933, 1, NULL, NULL, NULL, '20.38', NULL, '2019-06-24 10:01:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (934, 2, 8447492096, 4997533696, 3449958400, '59.16', NULL, '2019-06-24 10:01:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (935, 1, NULL, NULL, NULL, '25.13', NULL, '2019-06-24 10:01:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (936, 2, 8447492096, 5060112384, 3387379712, '59.90', NULL, '2019-06-24 10:01:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (937, 1, NULL, NULL, NULL, '36.83', NULL, '2019-06-24 10:02:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (938, 2, 8447492096, 5048270848, 3399221248, '59.76', NULL, '2019-06-24 10:02:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (939, 1, NULL, NULL, NULL, '28.75', NULL, '2019-06-24 10:02:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (940, 2, 8447492096, 5060546560, 3386945536, '59.91', NULL, '2019-06-24 10:02:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (941, 1, NULL, NULL, NULL, '37.49', NULL, '2019-06-24 10:03:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (942, 2, 8447492096, 5171351552, 3276140544, '61.22', NULL, '2019-06-24 10:03:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (943, 1, NULL, NULL, NULL, '32.76', NULL, '2019-06-24 10:03:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (944, 2, 8447492096, 5315964928, 3131527168, '62.93', NULL, '2019-06-24 10:03:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (945, 1, NULL, NULL, NULL, '34.65', NULL, '2019-06-24 10:04:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (946, 2, 8447492096, 5405736960, 3041755136, '63.99', NULL, '2019-06-24 10:04:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (947, 1, NULL, NULL, NULL, '38.45', NULL, '2019-06-24 10:04:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (948, 2, 8447492096, 5452673024, 2994819072, '64.55', NULL, '2019-06-24 10:04:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (949, 1, NULL, NULL, NULL, '39.62', NULL, '2019-06-24 10:05:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (950, 2, 8447492096, 5415743488, 3031748608, '64.11', NULL, '2019-06-24 10:05:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (951, 1, NULL, NULL, NULL, '36.92', NULL, '2019-06-24 10:05:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (952, 2, 8447492096, 5449486336, 2998005760, '64.51', NULL, '2019-06-24 10:05:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (953, 1, NULL, NULL, NULL, '46.22', NULL, '2019-06-24 10:06:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (954, 2, 8447492096, 5645778944, 2801713152, '66.83', NULL, '2019-06-24 10:06:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (955, 1, NULL, NULL, NULL, '49.69', NULL, '2019-06-24 10:06:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (956, 2, 8447492096, 5675929600, 2771562496, '67.19', NULL, '2019-06-24 10:06:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (957, 1, NULL, NULL, NULL, '47.67', NULL, '2019-06-24 10:07:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (958, 2, 8447492096, 5576617984, 2870874112, '66.02', NULL, '2019-06-24 10:07:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (959, 1, NULL, NULL, NULL, '35.51', NULL, '2019-06-24 10:07:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (960, 2, 8447492096, 5612695552, 2834796544, '66.44', NULL, '2019-06-24 10:07:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (961, 1, NULL, NULL, NULL, '39.72', NULL, '2019-06-24 10:08:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (962, 2, 8447492096, 5604925440, 2842566656, '66.35', NULL, '2019-06-24 10:08:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (963, 1, NULL, NULL, NULL, '46.69', NULL, '2019-06-24 10:08:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (964, 2, 8447492096, 5581271040, 2866221056, '66.07', NULL, '2019-06-24 10:08:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (965, 1, NULL, NULL, NULL, '34.55', NULL, '2019-06-24 10:09:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (966, 2, 8447492096, 5598879744, 2848612352, '66.28', NULL, '2019-06-24 10:09:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (967, 1, NULL, NULL, NULL, '40.42', NULL, '2019-06-24 10:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (968, 2, 8447492096, 5548187648, 2899304448, '65.68', NULL, '2019-06-24 10:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (969, 1, NULL, NULL, NULL, '34.41', NULL, '2019-06-24 10:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (970, 2, 8447492096, 5523427328, 2924064768, '65.39', NULL, '2019-06-24 10:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (971, 1, NULL, NULL, NULL, '52.99', NULL, '2019-06-24 10:16:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (972, 2, 8447492096, 4768538624, 3678953472, '56.45', NULL, '2019-06-24 10:16:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (973, 1, NULL, NULL, NULL, '51.48', NULL, '2019-06-24 10:17:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (974, 2, 8447492096, 4821561344, 3625930752, '57.08', NULL, '2019-06-24 10:17:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (975, 1, NULL, NULL, NULL, '35.27', NULL, '2019-06-24 10:17:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (976, 2, 8447492096, 5232590848, 3214901248, '61.94', NULL, '2019-06-24 10:17:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (977, 1, NULL, NULL, NULL, '34.85', NULL, '2019-06-24 10:18:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (978, 2, 8447492096, 5255282688, 3192209408, '62.21', NULL, '2019-06-24 10:18:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (979, 1, NULL, NULL, NULL, '32.54', NULL, '2019-06-24 10:18:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (980, 2, 8447492096, 5258186752, 3189305344, '62.25', NULL, '2019-06-24 10:18:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (981, 1, NULL, NULL, NULL, '23.61', NULL, '2019-06-24 10:19:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (982, 2, 8447492096, 5348577280, 3098914816, '63.32', NULL, '2019-06-24 10:19:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (983, 1, NULL, NULL, NULL, '26.46', NULL, '2019-06-24 10:19:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (984, 2, 8447492096, 5456941056, 2990551040, '64.60', NULL, '2019-06-24 10:19:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (985, 1, NULL, NULL, NULL, '20.83', NULL, '2019-06-24 10:20:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (986, 2, 8447492096, 5435428864, 3012063232, '64.34', NULL, '2019-06-24 10:20:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (987, 1, NULL, NULL, NULL, '25.25', NULL, '2019-06-24 10:20:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (988, 2, 8447492096, 5553098752, 2894393344, '65.74', NULL, '2019-06-24 10:20:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (989, 1, NULL, NULL, NULL, '31.81', NULL, '2019-06-24 10:21:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (990, 2, 8447492096, 5688721408, 2758770688, '67.34', NULL, '2019-06-24 10:21:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (991, 1, NULL, NULL, NULL, '25.13', NULL, '2019-06-24 10:21:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (992, 2, 8447492096, 5734453248, 2713038848, '67.88', NULL, '2019-06-24 10:21:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (993, 1, NULL, NULL, NULL, '20.76', NULL, '2019-06-24 10:22:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (994, 2, 8447492096, 5745254400, 2702237696, '68.01', NULL, '2019-06-24 10:22:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (995, 1, NULL, NULL, NULL, '17.76', NULL, '2019-06-24 10:22:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (996, 2, 8447492096, 5710950400, 2736541696, '67.61', NULL, '2019-06-24 10:22:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (997, 1, NULL, NULL, NULL, '15.82', NULL, '2019-06-24 10:23:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (998, 2, 8447492096, 5707358208, 2740133888, '67.56', NULL, '2019-06-24 10:23:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (999, 1, NULL, NULL, NULL, '15.40', NULL, '2019-06-24 10:23:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1000, 2, 8447492096, 5723844608, 2723647488, '67.76', NULL, '2019-06-24 10:23:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1001, 1, NULL, NULL, NULL, '15.99', NULL, '2019-06-24 10:24:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1002, 2, 8447492096, 5725585408, 2721906688, '67.78', NULL, '2019-06-24 10:24:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1003, 1, NULL, NULL, NULL, '16.64', NULL, '2019-06-24 10:24:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1004, 2, 8447492096, 5675220992, 2772271104, '67.18', NULL, '2019-06-24 10:24:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1005, 1, NULL, NULL, NULL, '15.91', NULL, '2019-06-24 10:25:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1006, 2, 8447492096, 5715947520, 2731544576, '67.66', NULL, '2019-06-24 10:25:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1007, 1, NULL, NULL, NULL, '18.75', NULL, '2019-06-24 10:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1008, 2, 8447492096, 5802778624, 2644713472, '68.69', NULL, '2019-06-24 10:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1009, 1, NULL, NULL, NULL, '37.29', NULL, '2019-06-24 10:26:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1010, 2, 8447492096, 6194532352, 2252959744, '73.33', NULL, '2019-06-24 10:26:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1011, 1, NULL, NULL, NULL, '34.89', NULL, '2019-06-24 10:26:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1012, 2, 8447492096, 6229766144, 2217725952, '73.75', NULL, '2019-06-24 10:26:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1013, 1, NULL, NULL, NULL, '43.49', NULL, '2019-06-24 10:27:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1014, 2, 8447492096, 6475907072, 1971585024, '76.66', NULL, '2019-06-24 10:27:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1015, 1, NULL, NULL, NULL, '32.11', NULL, '2019-06-24 10:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1016, 2, 8447492096, 6535028736, 1912463360, '77.36', NULL, '2019-06-24 10:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1017, 1, NULL, NULL, NULL, '22.93', NULL, '2019-06-24 10:28:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1018, 2, 8447492096, 6458241024, 1989251072, '76.45', NULL, '2019-06-24 10:28:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1019, 1, NULL, NULL, NULL, '22.37', NULL, '2019-06-24 10:28:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1020, 2, 8447492096, 6446555136, 2000936960, '76.31', NULL, '2019-06-24 10:28:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1021, 1, NULL, NULL, NULL, '22.62', NULL, '2019-06-24 10:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1022, 2, 8447492096, 6450425856, 1997066240, '76.36', NULL, '2019-06-24 10:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1023, 1, NULL, NULL, NULL, '18.76', NULL, '2019-06-24 10:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1024, 2, 8447492096, 6485950464, 1961541632, '76.78', NULL, '2019-06-24 10:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1025, 1, NULL, NULL, NULL, '17.96', NULL, '2019-06-24 10:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1026, 2, 8447492096, 6495862784, 1951629312, '76.90', NULL, '2019-06-24 10:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1027, 1, NULL, NULL, NULL, '18.56', NULL, '2019-06-24 10:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1028, 2, 8447492096, 6498803712, 1948688384, '76.93', NULL, '2019-06-24 10:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1029, 1, NULL, NULL, NULL, '18.86', NULL, '2019-06-24 10:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1030, 2, 8447492096, 6487777280, 1959714816, '76.80', NULL, '2019-06-24 10:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1031, 1, NULL, NULL, NULL, '17.78', NULL, '2019-06-24 10:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1032, 2, 8447492096, 6511439872, 1936052224, '77.08', NULL, '2019-06-24 10:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1033, 1, NULL, NULL, NULL, '19.89', NULL, '2019-06-24 10:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1034, 2, 8447492096, 6448435200, 1999056896, '76.34', NULL, '2019-06-24 10:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1035, 1, NULL, NULL, NULL, '36.93', NULL, '2019-06-24 10:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1036, 2, 8447492096, 6660136960, 1787355136, '78.84', NULL, '2019-06-24 10:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1037, 1, NULL, NULL, NULL, '32.75', NULL, '2019-06-24 10:33:03', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1038, 2, 8447492096, 6469074944, 1978417152, '76.58', NULL, '2019-06-24 10:33:03', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1039, 1, NULL, NULL, NULL, '23.01', NULL, '2019-06-24 10:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1040, 2, 8447492096, 6528737280, 1918754816, '77.29', NULL, '2019-06-24 10:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1041, 1, NULL, NULL, NULL, '17.24', NULL, '2019-06-24 10:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1042, 2, 8447492096, 6530641920, 1916850176, '77.31', NULL, '2019-06-24 10:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1043, 1, NULL, NULL, NULL, '18.27', NULL, '2019-06-24 10:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1044, 2, 8447492096, 6537535488, 1909956608, '77.39', NULL, '2019-06-24 10:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1045, 1, NULL, NULL, NULL, '34.34', NULL, '2019-06-24 10:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1046, 2, 8447492096, 6673367040, 1774125056, '79.00', NULL, '2019-06-24 10:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1047, 1, NULL, NULL, NULL, '43.14', NULL, '2019-06-24 10:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1048, 2, 8447492096, 6680698880, 1766793216, '79.08', NULL, '2019-06-24 10:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1049, 1, NULL, NULL, NULL, '32.79', NULL, '2019-06-24 10:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1050, 2, 8447492096, 6697979904, 1749512192, '79.29', NULL, '2019-06-24 10:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1051, 1, NULL, NULL, NULL, '36.06', NULL, '2019-06-24 10:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1052, 2, 8447492096, 6798716928, 1648775168, '80.48', NULL, '2019-06-24 10:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1053, 1, NULL, NULL, NULL, '46.48', NULL, '2019-06-24 10:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1054, 2, 8447492096, 6826020864, 1621471232, '80.81', NULL, '2019-06-24 10:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1055, 1, NULL, NULL, NULL, '38.95', NULL, '2019-06-24 10:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1056, 2, 8447492096, 6812999680, 1634492416, '80.65', NULL, '2019-06-24 10:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1057, 1, NULL, NULL, NULL, '33.59', NULL, '2019-06-24 10:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1058, 2, 8447492096, 6794039296, 1653452800, '80.43', NULL, '2019-06-24 10:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1059, 1, NULL, NULL, NULL, '35.40', NULL, '2019-06-24 10:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1060, 2, 8447492096, 6745481216, 1702010880, '79.85', NULL, '2019-06-24 10:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1061, 1, NULL, NULL, NULL, '42.47', NULL, '2019-06-24 10:39:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1062, 2, 8447492096, 6855151616, 1592340480, '81.15', NULL, '2019-06-24 10:39:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1063, 1, NULL, NULL, NULL, '34.47', NULL, '2019-06-24 10:39:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1064, 2, 8447492096, 6833311744, 1614180352, '80.89', NULL, '2019-06-24 10:39:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1065, 1, NULL, NULL, NULL, '43.31', NULL, '2019-06-24 10:40:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1066, 2, 8447492096, 6888517632, 1558974464, '81.55', NULL, '2019-06-24 10:40:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1067, 1, NULL, NULL, NULL, '35.90', NULL, '2019-06-24 10:40:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1068, 2, 8447492096, 6918668288, 1528823808, '81.90', NULL, '2019-06-24 10:40:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1069, 1, NULL, NULL, NULL, '27.34', NULL, '2019-06-24 10:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1070, 2, 8447492096, 6930231296, 1517260800, '82.04', NULL, '2019-06-24 10:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1071, 1, NULL, NULL, NULL, '26.17', NULL, '2019-06-24 10:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1072, 2, 8447492096, 6987927552, 1459564544, '82.72', NULL, '2019-06-24 10:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1073, 1, NULL, NULL, NULL, '22.59', NULL, '2019-06-24 10:42:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1074, 2, 8447492096, 6941003776, 1506488320, '82.17', NULL, '2019-06-24 10:42:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1075, 1, NULL, NULL, NULL, '19.96', NULL, '2019-06-24 10:42:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1076, 2, 8447492096, 6907678720, 1539813376, '81.77', NULL, '2019-06-24 10:42:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1077, 1, NULL, NULL, NULL, '20.50', NULL, '2019-06-24 10:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1078, 2, 8447492096, 6939369472, 1508122624, '82.15', NULL, '2019-06-24 10:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1079, 1, NULL, NULL, NULL, '20.27', NULL, '2019-06-24 10:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1080, 2, 8447492096, 6948118528, 1499373568, '82.25', NULL, '2019-06-24 10:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1081, 1, NULL, NULL, NULL, '25.55', NULL, '2019-06-24 10:44:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1082, 2, 8447492096, 6942593024, 1504899072, '82.19', NULL, '2019-06-24 10:44:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1083, 1, NULL, NULL, NULL, '32.07', NULL, '2019-06-24 10:44:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1084, 2, 8447492096, 6919073792, 1528418304, '81.91', NULL, '2019-06-24 10:44:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1085, 1, NULL, NULL, NULL, '25.50', NULL, '2019-06-24 10:45:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1086, 2, 8447492096, 6844329984, 1603162112, '81.02', NULL, '2019-06-24 10:45:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1087, 1, NULL, NULL, NULL, '20.03', NULL, '2019-06-24 10:45:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1088, 2, 8447492096, 6816055296, 1631436800, '80.69', NULL, '2019-06-24 10:45:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1089, 1, NULL, NULL, NULL, '20.95', NULL, '2019-06-24 10:46:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1090, 2, 8447492096, 6827520000, 1619972096, '80.82', NULL, '2019-06-24 10:46:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1091, 1, NULL, NULL, NULL, '18.13', NULL, '2019-06-24 10:46:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1092, 2, 8447492096, 6798479360, 1649012736, '80.48', NULL, '2019-06-24 10:46:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1093, 1, NULL, NULL, NULL, '22.25', NULL, '2019-06-24 10:47:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1094, 2, 8447492096, 6558715904, 1888776192, '77.64', NULL, '2019-06-24 10:47:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1095, 1, NULL, NULL, NULL, '16.81', NULL, '2019-06-24 10:47:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1096, 2, 8447492096, 6604402688, 1843089408, '78.18', NULL, '2019-06-24 10:47:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1097, 1, NULL, NULL, NULL, '16.29', NULL, '2019-06-24 10:48:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1098, 2, 8447492096, 6608199680, 1839292416, '78.23', NULL, '2019-06-24 10:48:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1099, 1, NULL, NULL, NULL, '19.22', NULL, '2019-06-24 10:48:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1100, 2, 8447492096, 6577143808, 1870348288, '77.86', NULL, '2019-06-24 10:48:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1101, 1, NULL, NULL, NULL, '17.36', NULL, '2019-06-24 10:49:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1102, 2, 8447492096, 6574903296, 1872588800, '77.83', NULL, '2019-06-24 10:49:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1103, 1, NULL, NULL, NULL, '17.72', NULL, '2019-06-24 10:49:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1104, 2, 8447492096, 6569574400, 1877917696, '77.77', NULL, '2019-06-24 10:49:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1105, 1, NULL, NULL, NULL, '17.06', NULL, '2019-06-24 10:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1106, 2, 8447492096, 6570196992, 1877295104, '77.78', NULL, '2019-06-24 10:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1107, 1, NULL, NULL, NULL, '16.97', NULL, '2019-06-24 10:50:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1108, 2, 8447492096, 6580416512, 1867075584, '77.90', NULL, '2019-06-24 10:50:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1109, 1, NULL, NULL, NULL, '17.99', NULL, '2019-06-24 10:51:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1110, 2, 8447492096, 6577520640, 1869971456, '77.86', NULL, '2019-06-24 10:51:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1111, 1, NULL, NULL, NULL, '17.33', NULL, '2019-06-24 10:51:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1112, 2, 8447492096, 6595514368, 1851977728, '78.08', NULL, '2019-06-24 10:51:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1113, 1, NULL, NULL, NULL, '18.97', NULL, '2019-06-24 10:52:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1114, 2, 8447492096, 6410194944, 2037297152, '75.88', NULL, '2019-06-24 10:52:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1115, 1, NULL, NULL, NULL, '23.25', NULL, '2019-06-24 10:52:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1116, 2, 8447492096, 6434570240, 2012921856, '76.17', NULL, '2019-06-24 10:52:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1117, 1, NULL, NULL, NULL, '16.89', NULL, '2019-06-24 10:53:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1118, 2, 8447492096, 6443122688, 2004369408, '76.27', NULL, '2019-06-24 10:53:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1119, 1, NULL, NULL, NULL, '18.85', NULL, '2019-06-24 10:53:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1120, 2, 8447492096, 6458462208, 1989029888, '76.45', NULL, '2019-06-24 10:53:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1121, 1, NULL, NULL, NULL, '18.00', NULL, '2019-06-24 10:54:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1122, 2, 8447492096, 6459453440, 1988038656, '76.47', NULL, '2019-06-24 10:54:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1123, 1, NULL, NULL, NULL, '18.59', NULL, '2019-06-24 10:54:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1124, 2, 8447492096, 6479114240, 1968377856, '76.70', NULL, '2019-06-24 10:54:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1125, 1, NULL, NULL, NULL, '17.58', NULL, '2019-06-24 10:55:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1126, 2, 8447492096, 6408327168, 2039164928, '75.86', NULL, '2019-06-24 10:55:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1127, 1, NULL, NULL, NULL, '19.12', NULL, '2019-06-24 10:55:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1128, 2, 8447492096, 6450647040, 1996845056, '76.36', NULL, '2019-06-24 10:55:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1129, 1, NULL, NULL, NULL, '15.39', NULL, '2019-06-24 10:56:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1130, 2, 8447492096, 6426492928, 2020999168, '76.08', NULL, '2019-06-24 10:56:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1131, 1, NULL, NULL, NULL, '15.47', NULL, '2019-06-24 10:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1132, 2, 8447492096, 6396219392, 2051272704, '75.72', NULL, '2019-06-24 10:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1133, 1, NULL, NULL, NULL, '18.03', NULL, '2019-06-24 10:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1134, 2, 8447492096, 6390239232, 2057252864, '75.65', NULL, '2019-06-24 10:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1135, 1, NULL, NULL, NULL, '18.74', NULL, '2019-06-24 10:57:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1136, 2, 8447492096, 6442713088, 2004779008, '76.27', NULL, '2019-06-24 10:57:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1137, 1, NULL, NULL, NULL, '14.01', NULL, '2019-06-24 10:58:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1138, 2, 8447492096, 6426673152, 2020818944, '76.08', NULL, '2019-06-24 10:58:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1139, 1, NULL, NULL, NULL, '13.66', NULL, '2019-06-24 10:58:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1140, 2, 8447492096, 6402633728, 2044858368, '75.79', NULL, '2019-06-24 10:58:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1141, 1, NULL, NULL, NULL, '15.75', NULL, '2019-06-24 10:59:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1142, 2, 8447492096, 6372069376, 2075422720, '75.43', NULL, '2019-06-24 10:59:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1143, 1, NULL, NULL, NULL, '14.13', NULL, '2019-06-24 10:59:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1144, 2, 8447492096, 6374273024, 2073219072, '75.46', NULL, '2019-06-24 10:59:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1145, 1, NULL, NULL, NULL, '14.90', NULL, '2019-06-24 11:00:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1146, 2, 8447492096, 6364856320, 2082635776, '75.35', NULL, '2019-06-24 11:00:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1147, 1, NULL, NULL, NULL, '16.63', NULL, '2019-06-24 11:00:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1148, 2, 8447492096, 6373376000, 2074116096, '75.45', NULL, '2019-06-24 11:00:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1149, 1, NULL, NULL, NULL, '15.82', NULL, '2019-06-24 11:01:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1150, 2, 8447492096, 6369861632, 2077630464, '75.41', NULL, '2019-06-24 11:01:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1151, 1, NULL, NULL, NULL, '16.45', NULL, '2019-06-24 11:01:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1152, 2, 8447492096, 6385000448, 2062491648, '75.58', NULL, '2019-06-24 11:01:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1153, 1, NULL, NULL, NULL, '17.56', NULL, '2019-06-24 11:02:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1154, 2, 8447492096, 6370791424, 2076700672, '75.42', NULL, '2019-06-24 11:02:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1155, 1, NULL, NULL, NULL, '22.76', NULL, '2019-06-24 11:02:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1156, 2, 8447492096, 6375485440, 2072006656, '75.47', NULL, '2019-06-24 11:02:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1157, 1, NULL, NULL, NULL, '15.00', NULL, '2019-06-24 11:03:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1158, 2, 8447492096, 6371995648, 2075496448, '75.43', NULL, '2019-06-24 11:03:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1159, 1, NULL, NULL, NULL, '15.78', NULL, '2019-06-24 11:03:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1160, 2, 8447492096, 6389813248, 2057678848, '75.64', NULL, '2019-06-24 11:03:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1161, 1, NULL, NULL, NULL, '16.90', NULL, '2019-06-24 11:04:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1162, 2, 8447492096, 6386106368, 2061385728, '75.60', NULL, '2019-06-24 11:04:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1163, 1, NULL, NULL, NULL, '16.20', NULL, '2019-06-24 11:04:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1164, 2, 8447492096, 6370775040, 2076717056, '75.42', NULL, '2019-06-24 11:04:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1165, 1, NULL, NULL, NULL, '14.60', NULL, '2019-06-24 11:05:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1166, 2, 8447492096, 6383276032, 2064216064, '75.56', NULL, '2019-06-24 11:05:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1167, 1, NULL, NULL, NULL, '16.90', NULL, '2019-06-24 11:05:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1168, 2, 8447492096, 6334509056, 2112983040, '74.99', NULL, '2019-06-24 11:05:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1169, 1, NULL, NULL, NULL, '15.66', NULL, '2019-06-24 11:06:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1170, 2, 8447492096, 6326091776, 2121400320, '74.89', NULL, '2019-06-24 11:06:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1171, 1, NULL, NULL, NULL, '15.72', NULL, '2019-06-24 11:06:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1172, 2, 8447492096, 6340427776, 2107064320, '75.06', NULL, '2019-06-24 11:06:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1173, 1, NULL, NULL, NULL, '17.67', NULL, '2019-06-24 11:07:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1174, 2, 8447492096, 6297862144, 2149629952, '74.55', NULL, '2019-06-24 11:07:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1175, 1, NULL, NULL, NULL, '15.10', NULL, '2019-06-24 11:07:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1176, 2, 8447492096, 6291247104, 2156244992, '74.47', NULL, '2019-06-24 11:07:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1177, 1, NULL, NULL, NULL, '14.08', NULL, '2019-06-24 11:08:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1178, 2, 8447492096, 6285193216, 2162298880, '74.40', NULL, '2019-06-24 11:08:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1179, 1, NULL, NULL, NULL, '14.09', NULL, '2019-06-24 11:08:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1180, 2, 8447492096, 6289383424, 2158108672, '74.45', NULL, '2019-06-24 11:08:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1181, 1, NULL, NULL, NULL, '13.23', NULL, '2019-06-24 11:09:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1182, 2, 8447492096, 6288486400, 2159005696, '74.44', NULL, '2019-06-24 11:09:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1183, 1, NULL, NULL, NULL, '13.53', NULL, '2019-06-24 11:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1184, 2, 8447492096, 6269423616, 2178068480, '74.22', NULL, '2019-06-24 11:09:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1185, 1, NULL, NULL, NULL, '15.37', NULL, '2019-06-24 11:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1186, 2, 8447492096, 6277935104, 2169556992, '74.32', NULL, '2019-06-24 11:10:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1187, 1, NULL, NULL, NULL, '14.83', NULL, '2019-06-24 11:10:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1188, 2, 8447492096, 6265843712, 2181648384, '74.17', NULL, '2019-06-24 11:10:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1189, 1, NULL, NULL, NULL, '12.79', NULL, '2019-06-24 11:11:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1190, 2, 8447492096, 6257610752, 2189881344, '74.08', NULL, '2019-06-24 11:11:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1191, 1, NULL, NULL, NULL, '13.74', NULL, '2019-06-24 11:11:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1192, 2, 8447492096, 6294392832, 2153099264, '74.51', NULL, '2019-06-24 11:11:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1193, 1, NULL, NULL, NULL, '13.44', NULL, '2019-06-24 11:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1194, 2, 8447492096, 6288003072, 2159489024, '74.44', NULL, '2019-06-24 11:12:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1195, 1, NULL, NULL, NULL, '14.25', NULL, '2019-06-24 11:12:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1196, 2, 8447492096, 6275350528, 2172141568, '74.29', NULL, '2019-06-24 11:12:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1197, 1, NULL, NULL, NULL, '17.04', NULL, '2019-06-24 11:13:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1198, 2, 8447492096, 6300684288, 2146807808, '74.59', NULL, '2019-06-24 11:13:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1199, 1, NULL, NULL, NULL, '15.26', NULL, '2019-06-24 11:13:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1200, 2, 8447492096, 6297911296, 2149580800, '74.55', NULL, '2019-06-24 11:13:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1201, 1, NULL, NULL, NULL, '13.76', NULL, '2019-06-24 11:14:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1202, 2, 8447492096, 6298419200, 2149072896, '74.56', NULL, '2019-06-24 11:14:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1203, 1, NULL, NULL, NULL, '13.91', NULL, '2019-06-24 11:14:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1204, 2, 8447492096, 6302916608, 2144575488, '74.61', NULL, '2019-06-24 11:14:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1205, 1, NULL, NULL, NULL, '15.47', NULL, '2019-06-24 11:15:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1206, 2, 8447492096, 6295093248, 2152398848, '74.52', NULL, '2019-06-24 11:15:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1207, 1, NULL, NULL, NULL, '14.52', NULL, '2019-06-24 11:15:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1208, 2, 8447492096, 6315708416, 2131783680, '74.76', NULL, '2019-06-24 11:15:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1209, 1, NULL, NULL, NULL, '16.54', NULL, '2019-06-24 11:16:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1210, 2, 8447492096, 6308970496, 2138521600, '74.68', NULL, '2019-06-24 11:16:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1211, 1, NULL, NULL, NULL, '14.57', NULL, '2019-06-24 11:16:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1212, 2, 8447492096, 6311047168, 2136444928, '74.71', NULL, '2019-06-24 11:16:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1213, 1, NULL, NULL, NULL, '14.96', NULL, '2019-06-24 11:17:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1214, 2, 8447492096, 6295744512, 2151747584, '74.53', NULL, '2019-06-24 11:17:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1215, 1, NULL, NULL, NULL, '15.98', NULL, '2019-06-24 11:17:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1216, 2, 8447492096, 6395121664, 2052370432, '75.70', NULL, '2019-06-24 11:17:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1217, 1, NULL, NULL, NULL, '13.55', NULL, '2019-06-24 11:18:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1218, 2, 8447492096, 6384197632, 2063294464, '75.58', NULL, '2019-06-24 11:18:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1219, 1, NULL, NULL, NULL, '14.82', NULL, '2019-06-24 11:18:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1220, 2, 8447492096, 6340984832, 2106507264, '75.06', NULL, '2019-06-24 11:18:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1221, 1, NULL, NULL, NULL, '26.82', NULL, '2019-06-24 11:19:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1222, 2, 8447492096, 6566146048, 1881346048, '77.73', NULL, '2019-06-24 11:19:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1223, 1, NULL, NULL, NULL, '18.83', NULL, '2019-06-24 11:19:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1224, 2, 8447492096, 6447464448, 2000027648, '76.32', NULL, '2019-06-24 11:19:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1225, 1, NULL, NULL, NULL, '24.11', NULL, '2019-06-24 11:20:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1226, 2, 8447492096, 6437601280, 2009890816, '76.21', NULL, '2019-06-24 11:20:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1227, 1, NULL, NULL, NULL, '16.91', NULL, '2019-06-24 11:21:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1228, 2, 8447492096, 6411943936, 2035548160, '75.90', NULL, '2019-06-24 11:21:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1229, 1, NULL, NULL, NULL, '16.38', NULL, '2019-06-24 11:21:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1230, 2, 8447492096, 6432202752, 2015289344, '76.14', NULL, '2019-06-24 11:21:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1231, 1, NULL, NULL, NULL, '17.41', NULL, '2019-06-24 11:22:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1232, 2, 8447492096, 6457036800, 1990455296, '76.44', NULL, '2019-06-24 11:22:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1233, 1, NULL, NULL, NULL, '16.37', NULL, '2019-06-24 11:22:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1234, 2, 8447492096, 6447591424, 1999900672, '76.33', NULL, '2019-06-24 11:22:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1235, 1, NULL, NULL, NULL, '18.52', NULL, '2019-06-24 11:23:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1236, 2, 8447492096, 6406041600, 2041450496, '75.83', NULL, '2019-06-24 11:23:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1237, 1, NULL, NULL, NULL, '19.14', NULL, '2019-06-24 11:23:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1238, 2, 8447492096, 6377926656, 2069565440, '75.50', NULL, '2019-06-24 11:23:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1239, 1, NULL, NULL, NULL, '14.13', NULL, '2019-06-24 11:24:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1240, 2, 8447492096, 6319079424, 2128412672, '74.80', NULL, '2019-06-24 11:24:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1241, 1, NULL, NULL, NULL, '14.00', NULL, '2019-06-24 11:24:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1242, 2, 8447492096, 6265487360, 2182004736, '74.17', NULL, '2019-06-24 11:24:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1243, 1, NULL, NULL, NULL, '17.36', NULL, '2019-06-24 11:25:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1244, 2, 8447492096, 6157778944, 2289713152, '72.89', NULL, '2019-06-24 11:25:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1245, 1, NULL, NULL, NULL, '11.96', NULL, '2019-06-24 11:25:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1246, 2, 12762304512, 6079303680, 6683000832, '47.63', NULL, '2019-06-24 11:25:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1247, 1, NULL, NULL, NULL, '18.56', NULL, '2019-06-24 11:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1248, 2, 8447492096, 6122151936, 2325340160, '72.47', NULL, '2019-06-24 11:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1249, 1, NULL, NULL, NULL, '20.83', NULL, '2019-06-24 11:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1250, 2, 12762304512, 6269632512, 6492672000, '49.13', NULL, '2019-06-24 11:25:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1251, 1, NULL, NULL, NULL, '18.66', NULL, '2019-06-24 11:26:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1252, 2, 8447492096, 6089936896, 2357555200, '72.09', NULL, '2019-06-24 11:26:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1253, 1, NULL, NULL, NULL, '14.61', NULL, '2019-06-24 11:26:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1254, 2, 12762304512, 6260043776, 6502260736, '49.05', NULL, '2019-06-24 11:26:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1255, 1, NULL, NULL, NULL, '15.65', NULL, '2019-06-24 11:26:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1256, 2, 8447492096, 6085033984, 2362458112, '72.03', NULL, '2019-06-24 11:26:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1257, 1, NULL, NULL, NULL, '26.15', NULL, '2019-06-24 11:26:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1258, 2, 12762304512, 6266691584, 6495612928, '49.10', NULL, '2019-06-24 11:26:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1259, 1, NULL, NULL, NULL, '17.11', NULL, '2019-06-24 11:27:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1260, 2, 8447492096, 6019993600, 2427498496, '71.26', NULL, '2019-06-24 11:27:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1261, 1, NULL, NULL, NULL, '13.92', NULL, '2019-06-24 11:27:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1262, 2, 12762304512, 6193115136, 6569189376, '48.53', NULL, '2019-06-24 11:27:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1263, 1, NULL, NULL, NULL, '15.87', NULL, '2019-06-24 11:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1264, 2, 8447492096, 6027186176, 2420305920, '71.35', NULL, '2019-06-24 11:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1265, 1, NULL, NULL, NULL, '28.03', NULL, '2019-06-24 11:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1266, 2, 12762304512, 6638276608, 6124027904, '52.01', NULL, '2019-06-24 11:27:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1267, 1, NULL, NULL, NULL, '16.63', NULL, '2019-06-24 11:28:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1268, 2, 8447492096, 6024343552, 2423148544, '71.32', NULL, '2019-06-24 11:28:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1269, 1, NULL, NULL, NULL, '26.21', NULL, '2019-06-24 11:28:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1270, 2, 12762304512, 6589685760, 6172618752, '51.63', NULL, '2019-06-24 11:28:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1271, 1, NULL, NULL, NULL, '15.27', NULL, '2019-06-24 11:28:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1272, 2, 8447492096, 6023995392, 2423496704, '71.31', NULL, '2019-06-24 11:28:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1273, 1, NULL, NULL, NULL, '16.64', NULL, '2019-06-24 11:28:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1274, 2, 12762304512, 6527238144, 6235066368, '51.14', NULL, '2019-06-24 11:28:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1275, 1, NULL, NULL, NULL, '17.12', NULL, '2019-06-24 11:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1276, 2, 8447492096, 6022696960, 2424795136, '71.30', NULL, '2019-06-24 11:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1277, 1, NULL, NULL, NULL, '14.10', NULL, '2019-06-24 11:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1278, 2, 12762304512, 6462353408, 6299951104, '50.64', NULL, '2019-06-24 11:29:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1279, 1, NULL, NULL, NULL, '17.17', NULL, '2019-06-24 11:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1280, 2, 8447492096, 6011682816, 2435809280, '71.17', NULL, '2019-06-24 11:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1281, 1, NULL, NULL, NULL, '20.59', NULL, '2019-06-24 11:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1282, 2, 12762304512, 6427422720, 6334881792, '50.36', NULL, '2019-06-24 11:29:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1283, 1, NULL, NULL, NULL, '16.60', NULL, '2019-06-24 11:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1284, 2, 8447492096, 6006390784, 2441101312, '71.10', NULL, '2019-06-24 11:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1285, 1, NULL, NULL, NULL, '24.09', NULL, '2019-06-24 11:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1286, 2, 12762304512, 6375321600, 6386982912, '49.95', NULL, '2019-06-24 11:30:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1287, 1, NULL, NULL, NULL, '15.79', NULL, '2019-06-24 11:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1288, 2, 8447492096, 6015258624, 2432233472, '71.21', NULL, '2019-06-24 11:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1289, 1, NULL, NULL, NULL, '16.65', NULL, '2019-06-24 11:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1290, 2, 12762304512, 6344196096, 6418108416, '49.71', NULL, '2019-06-24 11:30:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1291, 1, NULL, NULL, NULL, '15.95', NULL, '2019-06-24 11:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1292, 2, 8447492096, 6024011776, 2423480320, '71.31', NULL, '2019-06-24 11:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1293, 1, NULL, NULL, NULL, '16.24', NULL, '2019-06-24 11:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1294, 2, 12762304512, 6301810688, 6460493824, '49.38', NULL, '2019-06-24 11:31:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1295, 1, NULL, NULL, NULL, '14.69', NULL, '2019-06-24 11:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1296, 2, 8447492096, 6006173696, 2441318400, '71.10', NULL, '2019-06-24 11:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1297, 1, NULL, NULL, NULL, '20.49', NULL, '2019-06-24 11:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1298, 2, 12762304512, 6334861312, 6427443200, '49.64', NULL, '2019-06-24 11:31:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1299, 1, NULL, NULL, NULL, '19.11', NULL, '2019-06-24 11:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1300, 2, 8447492096, 5955616768, 2491875328, '70.50', NULL, '2019-06-24 11:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1301, 1, NULL, NULL, NULL, '12.38', NULL, '2019-06-24 11:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1302, 2, 12762304512, 6318931968, 6443372544, '49.51', NULL, '2019-06-24 11:32:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1303, 1, NULL, NULL, NULL, '24.38', NULL, '2019-06-24 11:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1304, 2, 8447492096, 5803855872, 2643636224, '68.71', NULL, '2019-06-24 11:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1305, 1, NULL, NULL, NULL, '13.98', NULL, '2019-06-24 11:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1306, 2, 12762304512, 6321180672, 6441123840, '49.53', NULL, '2019-06-24 11:32:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1307, 1, NULL, NULL, NULL, '16.77', NULL, '2019-06-24 11:33:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1308, 2, 8447492096, 5796610048, 2650882048, '68.62', NULL, '2019-06-24 11:33:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1309, 1, NULL, NULL, NULL, '13.76', NULL, '2019-06-24 11:33:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1310, 2, 12762304512, 6314438656, 6447865856, '49.48', NULL, '2019-06-24 11:33:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1311, 1, NULL, NULL, NULL, '14.83', NULL, '2019-06-24 11:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1312, 2, 8447492096, 5771673600, 2675818496, '68.32', NULL, '2019-06-24 11:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1313, 1, NULL, NULL, NULL, '18.89', NULL, '2019-06-24 11:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1314, 2, 12762304512, 6192758784, 6569545728, '48.52', NULL, '2019-06-24 11:33:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1315, 1, NULL, NULL, NULL, '16.33', NULL, '2019-06-24 11:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1316, 2, 8447492096, 5773512704, 2673979392, '68.35', NULL, '2019-06-24 11:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1317, 1, NULL, NULL, NULL, '12.69', NULL, '2019-06-24 11:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1318, 2, 12762304512, 6752456704, 6009847808, '52.91', NULL, '2019-06-24 11:34:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1319, 1, NULL, NULL, NULL, '15.65', NULL, '2019-06-24 11:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1320, 2, 8447492096, 5820207104, 2627284992, '68.90', NULL, '2019-06-24 11:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1321, 1, NULL, NULL, NULL, '29.21', NULL, '2019-06-24 11:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1322, 2, 12762304512, 6721843200, 6040461312, '52.67', NULL, '2019-06-24 11:34:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1323, 1, NULL, NULL, NULL, '21.02', NULL, '2019-06-24 11:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1324, 2, 8447492096, 5830299648, 2617192448, '69.02', NULL, '2019-06-24 11:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1325, 1, NULL, NULL, NULL, '15.35', NULL, '2019-06-24 11:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1326, 2, 12762304512, 6727450624, 6034853888, '52.71', NULL, '2019-06-24 11:35:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1327, 1, NULL, NULL, NULL, '18.18', NULL, '2019-06-24 11:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1328, 2, 8447492096, 5819748352, 2627743744, '68.89', NULL, '2019-06-24 11:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1329, 1, NULL, NULL, NULL, '20.64', NULL, '2019-06-24 11:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1330, 2, 12762304512, 6698311680, 6063992832, '52.49', NULL, '2019-06-24 11:35:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1331, 1, NULL, NULL, NULL, '20.51', NULL, '2019-06-24 11:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1332, 2, 8447492096, 5831749632, 2615742464, '69.04', NULL, '2019-06-24 11:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1333, 1, NULL, NULL, NULL, '21.07', NULL, '2019-06-24 11:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1334, 2, 12762304512, 6675206144, 6087098368, '52.30', NULL, '2019-06-24 11:36:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1335, 1, NULL, NULL, NULL, '17.84', NULL, '2019-06-24 11:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1336, 2, 8447492096, 5817794560, 2629697536, '68.87', NULL, '2019-06-24 11:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1337, 1, NULL, NULL, NULL, '18.52', NULL, '2019-06-24 11:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1338, 2, 12762304512, 6187143168, 6575161344, '48.48', NULL, '2019-06-24 11:36:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1339, 1, NULL, NULL, NULL, '17.79', NULL, '2019-06-24 11:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1340, 2, 8447492096, 5821911040, 2625581056, '68.92', NULL, '2019-06-24 11:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1341, 1, NULL, NULL, NULL, '13.51', NULL, '2019-06-24 11:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1342, 2, 12762304512, 6151909376, 6610395136, '48.20', NULL, '2019-06-24 11:37:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1343, 1, NULL, NULL, NULL, '20.59', NULL, '2019-06-24 11:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1344, 2, 8447492096, 5829033984, 2618458112, '69.00', NULL, '2019-06-24 11:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1345, 1, NULL, NULL, NULL, '17.39', NULL, '2019-06-24 11:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1346, 2, 12762304512, 6086291456, 6676013056, '47.69', NULL, '2019-06-24 11:37:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1347, 1, NULL, NULL, NULL, '18.02', NULL, '2019-06-24 11:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1348, 2, 8447492096, 5796855808, 2650636288, '68.62', NULL, '2019-06-24 11:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1349, 1, NULL, NULL, NULL, '18.24', NULL, '2019-06-24 11:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1350, 2, 12762304512, 6116175872, 6646128640, '47.92', NULL, '2019-06-24 11:38:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1351, 1, NULL, NULL, NULL, '16.72', NULL, '2019-06-24 11:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1352, 2, 8447492096, 5790228480, 2657263616, '68.54', NULL, '2019-06-24 11:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1353, 1, NULL, NULL, NULL, '22.87', NULL, '2019-06-24 11:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1354, 2, 12762304512, 6173069312, 6589235200, '48.37', NULL, '2019-06-24 11:38:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1355, 1, NULL, NULL, NULL, '19.81', NULL, '2019-06-24 11:39:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1356, 2, 8447492096, 5797691392, 2649800704, '68.63', NULL, '2019-06-24 11:39:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1357, 1, NULL, NULL, NULL, '19.58', NULL, '2019-06-24 11:39:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1358, 2, 12762304512, 6056796160, 6705508352, '47.46', NULL, '2019-06-24 11:39:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1359, 1, NULL, NULL, NULL, '18.41', NULL, '2019-06-24 11:39:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1360, 2, 8447492096, 5782380544, 2665111552, '68.45', NULL, '2019-06-24 11:39:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1361, 1, NULL, NULL, NULL, '14.78', NULL, '2019-06-24 11:39:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1362, 2, 12762304512, 5892407296, 6869897216, '46.17', NULL, '2019-06-24 11:39:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1363, 1, NULL, NULL, NULL, '15.90', NULL, '2019-06-24 11:40:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1364, 2, 8447492096, 5780881408, 2666610688, '68.43', NULL, '2019-06-24 11:40:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1365, 1, NULL, NULL, NULL, '13.48', NULL, '2019-06-24 11:40:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1366, 2, 12762304512, 5856985088, 6905319424, '45.89', NULL, '2019-06-24 11:40:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1367, 1, NULL, NULL, NULL, '15.27', NULL, '2019-06-24 11:40:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1368, 2, 8447492096, 5771907072, 2675585024, '68.33', NULL, '2019-06-24 11:40:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1369, 1, NULL, NULL, NULL, '13.15', NULL, '2019-06-24 11:40:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1370, 2, 12762304512, 5832069120, 6930235392, '45.70', NULL, '2019-06-24 11:40:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1371, 1, NULL, NULL, NULL, '17.37', NULL, '2019-06-24 11:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1372, 2, 8447492096, 5764546560, 2682945536, '68.24', NULL, '2019-06-24 11:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1373, 1, NULL, NULL, NULL, '14.90', NULL, '2019-06-24 11:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1374, 2, 12762304512, 5622358016, 7139946496, '44.05', NULL, '2019-06-24 11:41:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1375, 1, NULL, NULL, NULL, '28.02', NULL, '2019-06-24 11:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1376, 2, 8447492096, 5734395904, 2713096192, '67.88', NULL, '2019-06-24 11:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1377, 1, NULL, NULL, NULL, '12.80', NULL, '2019-06-24 11:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1378, 2, 12762304512, 5618065408, 7144239104, '44.02', NULL, '2019-06-24 11:41:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1379, 1, NULL, NULL, NULL, '26.81', NULL, '2019-06-24 11:42:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1380, 2, 8447492096, 5770162176, 2677329920, '68.31', NULL, '2019-06-24 11:42:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1381, 1, NULL, NULL, NULL, '15.29', NULL, '2019-06-24 11:42:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1382, 2, 12762304512, 5627817984, 7134486528, '44.10', NULL, '2019-06-24 11:42:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1383, 1, NULL, NULL, NULL, '23.48', NULL, '2019-06-24 11:42:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1384, 2, 8447492096, 5788053504, 2659438592, '68.52', NULL, '2019-06-24 11:42:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1385, 1, NULL, NULL, NULL, '13.87', NULL, '2019-06-24 11:42:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1386, 2, 12762304512, 5632389120, 7129915392, '44.13', NULL, '2019-06-24 11:42:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1387, 1, NULL, NULL, NULL, '19.87', NULL, '2019-06-24 11:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1388, 2, 8447492096, 5777457152, 2670034944, '68.39', NULL, '2019-06-24 11:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1389, 1, NULL, NULL, NULL, '13.58', NULL, '2019-06-24 11:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1390, 2, 12762304512, 5626773504, 7135531008, '44.09', NULL, '2019-06-24 11:43:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1391, 1, NULL, NULL, NULL, '11.74', NULL, '2019-06-24 11:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1392, 2, 12762304512, 5625937920, 7136366592, '44.08', NULL, '2019-06-24 11:43:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1393, 1, NULL, NULL, NULL, '13.71', NULL, '2019-06-24 11:44:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1394, 2, 12762304512, 5626175488, 7136129024, '44.08', NULL, '2019-06-24 11:44:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1395, 1, NULL, NULL, NULL, '12.03', NULL, '2019-06-24 11:44:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1396, 2, 12762304512, 5616910336, 7145394176, '44.01', NULL, '2019-06-24 11:44:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1397, 1, NULL, NULL, NULL, '14.04', NULL, '2019-06-24 11:45:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1398, 2, 12762304512, 5620150272, 7142154240, '44.04', NULL, '2019-06-24 11:45:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1399, 1, NULL, NULL, NULL, '14.05', NULL, '2019-06-24 11:45:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1400, 2, 12762304512, 5624610816, 7137693696, '44.07', NULL, '2019-06-24 11:45:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1401, 1, NULL, NULL, NULL, '14.60', NULL, '2019-06-24 11:46:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1402, 2, 12762304512, 5615767552, 7146536960, '44.00', NULL, '2019-06-24 11:46:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1403, 1, NULL, NULL, NULL, '13.50', NULL, '2019-06-24 11:46:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1404, 2, 12762304512, 5627846656, 7134457856, '44.10', NULL, '2019-06-24 11:46:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1405, 1, NULL, NULL, NULL, '12.61', NULL, '2019-06-24 11:47:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1406, 2, 12762304512, 5631688704, 7130615808, '44.13', NULL, '2019-06-24 11:47:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1407, 1, NULL, NULL, NULL, '13.06', NULL, '2019-06-24 11:47:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1408, 2, 12762304512, 5622927360, 7139377152, '44.06', NULL, '2019-06-24 11:47:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1409, 1, NULL, NULL, NULL, '12.47', NULL, '2019-06-24 11:48:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1410, 2, 12762304512, 5614440448, 7147864064, '43.99', NULL, '2019-06-24 11:48:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1411, 1, NULL, NULL, NULL, '13.87', NULL, '2019-06-24 11:48:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1412, 2, 12762304512, 5618814976, 7143489536, '44.03', NULL, '2019-06-24 11:48:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1413, 1, NULL, NULL, NULL, '13.70', NULL, '2019-06-24 11:49:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1414, 2, 12762304512, 5635747840, 7126556672, '44.16', NULL, '2019-06-24 11:49:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1415, 1, NULL, NULL, NULL, '15.23', NULL, '2019-06-24 11:49:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1416, 2, 12762304512, 5664026624, 7098277888, '44.38', NULL, '2019-06-24 11:49:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1417, 1, NULL, NULL, NULL, '17.87', NULL, '2019-06-24 11:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1418, 2, 12762304512, 5725192192, 7037112320, '44.86', NULL, '2019-06-24 11:50:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1419, 1, NULL, NULL, NULL, '16.91', NULL, '2019-06-24 11:50:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1420, 2, 12762304512, 5723856896, 7038447616, '44.85', NULL, '2019-06-24 11:50:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1421, 1, NULL, NULL, NULL, '16.25', NULL, '2019-06-24 11:51:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1422, 2, 12762304512, 5751074816, 7011229696, '45.06', NULL, '2019-06-24 11:51:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1423, 1, NULL, NULL, NULL, '15.74', NULL, '2019-06-24 11:51:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1424, 2, 12762304512, 5778137088, 6984167424, '45.28', NULL, '2019-06-24 11:51:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1425, 1, NULL, NULL, NULL, '20.74', NULL, '2019-06-24 11:52:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1426, 2, 12762304512, 5824237568, 6938066944, '45.64', NULL, '2019-06-24 11:52:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1427, 1, NULL, NULL, NULL, '18.02', NULL, '2019-06-24 11:52:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1428, 2, 12762304512, 5833433088, 6928871424, '45.71', NULL, '2019-06-24 11:52:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1429, 1, NULL, NULL, NULL, '20.47', NULL, '2019-06-24 11:53:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1430, 2, 12762304512, 5862424576, 6899879936, '45.94', NULL, '2019-06-24 11:53:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1431, 1, NULL, NULL, NULL, '19.26', NULL, '2019-06-24 11:53:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1432, 2, 12762304512, 5814267904, 6948036608, '45.56', NULL, '2019-06-24 11:53:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1433, 1, NULL, NULL, NULL, '12.84', NULL, '2019-06-24 11:54:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1434, 2, 12762304512, 5809209344, 6953095168, '45.52', NULL, '2019-06-24 11:54:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1435, 1, NULL, NULL, NULL, '17.32', NULL, '2019-06-24 11:54:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1436, 2, 12762304512, 5794549760, 6967754752, '45.40', NULL, '2019-06-24 11:54:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1437, 1, NULL, NULL, NULL, '21.26', NULL, '2019-06-24 11:55:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1438, 2, 12762304512, 5859733504, 6902571008, '45.91', NULL, '2019-06-24 11:55:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1439, 1, NULL, NULL, NULL, '15.40', NULL, '2019-06-24 11:55:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1440, 2, 12762304512, 5869944832, 6892359680, '45.99', NULL, '2019-06-24 11:55:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1441, 1, NULL, NULL, NULL, '13.59', NULL, '2019-06-24 11:56:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1442, 2, 12762304512, 5804048384, 6958256128, '45.48', NULL, '2019-06-24 11:56:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1443, 1, NULL, NULL, NULL, '16.25', NULL, '2019-06-24 11:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1444, 2, 12762304512, 5839544320, 6922760192, '45.76', NULL, '2019-06-24 11:56:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1445, 1, NULL, NULL, NULL, '14.09', NULL, '2019-06-24 11:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1446, 2, 12762304512, 5794758656, 6967545856, '45.41', NULL, '2019-06-24 11:57:00', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1447, 1, NULL, NULL, NULL, '12.71', NULL, '2019-07-07 11:58:30', NULL, NULL, NULL, 0);
INSERT INTO `b_system_info_record` VALUES (1448, 2, 8504745984, 6840676352, 1664069632, '80.43', NULL, '2019-07-07 11:58:30', NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for b_teletext_terminal
-- ----------------------------
DROP TABLE IF EXISTS `b_teletext_terminal`;
CREATE TABLE `b_teletext_terminal`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_terminal_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '终端名称',
  `f_MAC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'MAC',
  `f_resource_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源编码',
  `f_device_type` tinyint(4) NULL DEFAULT NULL COMMENT '设备类型 枚举 0:字幕，1:图片，2:视频',
  `f_remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  `f_broadcast_area` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播发区域',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '图文终端表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_teletext_terminal
-- ----------------------------
INSERT INTO `b_teletext_terminal` VALUES (56, '终端1', '12-12-12-12-12-12', '061245140210220303', 0, NULL, 0, '2019-04-12 15:53:10', 1, NULL, 1, 1, '太平镇;');
INSERT INTO `b_teletext_terminal` VALUES (57, '终端2', '12-12-12-12-12-12', '061245140210220304', 0, NULL, 0, '2019-04-12 15:58:52', 1, NULL, NULL, 0, '新和镇;新和社区居委会;庆合村委会;通康村委会;作字村委会;兰山村委会;岜岩村委会;');
INSERT INTO `b_teletext_terminal` VALUES (58, '终端3', '12-12-12-12-12-12', '061245140210220305', 0, NULL, 0, '2019-04-12 17:23:01', 1, NULL, NULL, 0, '濑湍镇,旧街村委会,岜羊村委会,六京村委会,板兰村委会,陇丰村委会,全凤村委会,渠凹村委会,仁良村委会,九岸村委会,叫城村委会');
INSERT INTO `b_teletext_terminal` VALUES (59, '图文终端', '12-12-12-12-12', '061245140210220303', 2, NULL, 0, '2019-04-16 12:19:28', 1, NULL, NULL, 0, '六京村委会');

-- ----------------------------
-- Table structure for b_teletext_terminal_copy
-- ----------------------------
DROP TABLE IF EXISTS `b_teletext_terminal_copy`;
CREATE TABLE `b_teletext_terminal_copy`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_terminal_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '终端名称',
  `f_MAC` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'MAC',
  `f_resource_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源编码',
  `f_device_type` tinyint(4) NULL DEFAULT NULL COMMENT '设备类型 枚举 0:字幕，1:图片，2:视频',
  `f_remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  `f_broadcast_area` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播发区域',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '图文终端表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_teletext_terminal_copy
-- ----------------------------
INSERT INTO `b_teletext_terminal_copy` VALUES (13, '终端1', '', '', 0, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL);
INSERT INTO `b_teletext_terminal_copy` VALUES (14, '终端2', '', '', 0, NULL, NULL, NULL, NULL, NULL, 1, 1, NULL);
INSERT INTO `b_teletext_terminal_copy` VALUES (15, '终端', '9A:33:ED:3A:94:37', NULL, NULL, NULL, NULL, NULL, 1, NULL, 1, 1, NULL);
INSERT INTO `b_teletext_terminal_copy` VALUES (21, '00-E0-20-1C-7C-0C', '00-E0-20-1C-7C-0C', '00-E0-20-1C-7C-0C', 0, NULL, 0, '2019-01-01 20:19:54', 1, NULL, 1, 1, NULL);
INSERT INTO `b_teletext_terminal_copy` VALUES (23, '1111', '00-E0-20-1C-7C-0C', '00-E0-20-1C-7C-0C', 2, NULL, 0, '2019-01-03 16:49:36', 1, NULL, 1, 1, NULL);
INSERT INTO `b_teletext_terminal_copy` VALUES (24, '11', '00-E0-20-1C-7C-0C', '11', 2, NULL, 0, '2019-01-03 16:50:17', 1, NULL, 1, 1, NULL);
INSERT INTO `b_teletext_terminal_copy` VALUES (26, '8255', '00-E0-20-1C-7C-0C', '88', 0, NULL, 0, '2019-01-05 17:15:47', 1, NULL, 1, 1, NULL);
INSERT INTO `b_teletext_terminal_copy` VALUES (27, NULL, NULL, NULL, NULL, NULL, 0, '2019-01-07 13:28:11', 1, NULL, 1, 1, '29,20');
INSERT INTO `b_teletext_terminal_copy` VALUES (28, '1', '1', '1', 0, NULL, 0, '2019-01-17 16:06:08', 1, NULL, 1, 1, '1,2,22,20,3,4,30,5,6,7,8,9,10,11,12,13,14,15,16,17');
INSERT INTO `b_teletext_terminal_copy` VALUES (29, '测试终端2', '00-E0-20-1C-7C-0C', '3', 0, NULL, 0, '2019-01-28 13:04:34', 1, NULL, 1, 1, '1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17');
INSERT INTO `b_teletext_terminal_copy` VALUES (30, '测试终端6', '', '', 0, NULL, 0, '2019-01-28 13:06:16', 1, NULL, 1, 1, '4');
INSERT INTO `b_teletext_terminal_copy` VALUES (31, '00-E0-2', '00-E0-20-1C-7C-0C', '00-E0-20-1C-7C-0C', 0, NULL, 0, '2019-01-28 16:17:51', 1, NULL, 1, 1, '58,59');
INSERT INTO `b_teletext_terminal_copy` VALUES (32, '反对的是1', '', '', 1, NULL, 0, '2019-02-15 16:14:02', 1, NULL, 1, 1, '8');
INSERT INTO `b_teletext_terminal_copy` VALUES (33, '测试终端31', '', '', 2, NULL, 0, '2019-03-23 15:55:22', 1, NULL, 1, 1, '150,151,155,156,157,158,159');
INSERT INTO `b_teletext_terminal_copy` VALUES (34, '个大概多少', '00-E0-20-1C-7C-0C', '34442 3443', 0, NULL, 0, '2019-04-06 16:41:35', 1, NULL, 1, 1, '150,151,155,156,157,158,159');
INSERT INTO `b_teletext_terminal_copy` VALUES (35, '终端4', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-08 17:47:28', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (36, '终端5', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-08 17:51:33', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (37, '终端6', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-08 17:51:59', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (38, '终端7', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-08 17:53:05', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (39, '终端8', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-08 18:00:52', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (40, '终端9', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-08 18:03:45', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (41, '终端10', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-08 18:59:05', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (42, '终端11', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-08 19:10:12', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (43, '终端12', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-09 10:46:58', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (44, '终端13', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-09 10:59:01', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (45, '终端14', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-09 11:08:14', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (46, '终端15', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-09 11:20:51', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (47, '终端16', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-09 11:25:02', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (48, '终端17', '00-E0-20-1C-7C-0C', '1', 0, NULL, 0, '2019-04-09 11:31:41', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (49, '终端3', '12-12-12-12-12-12', '1', 0, NULL, 0, '2019-04-09 12:14:11', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (50, '终端4', '12-12-12-12-12-12', '1', 0, NULL, 0, '2019-04-09 12:18:07', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (51, '终端5', '12-12-12-12-12-12', '1', 0, NULL, 0, '2019-04-09 12:22:19', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (52, '终端6', '12-12-21-12-21-12', '1', 0, NULL, 0, '2019-04-09 13:02:12', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (53, '终端7', '12-12-12-12-12-12', '1', 0, NULL, 0, '2019-04-09 13:16:20', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (54, '终端8', '12-12-12-12-12-12', '1', 0, NULL, 0, '2019-04-09 13:17:45', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (55, '终端9', '12-12-12-12-12-12', '1', 0, NULL, 0, '2019-04-09 13:20:08', 1, NULL, 1, 1, '130');
INSERT INTO `b_teletext_terminal_copy` VALUES (56, '终端1', '12-12-12-12-12-12', '1', 0, NULL, 0, '2019-04-12 15:53:10', 1, NULL, NULL, 0, '太平镇;');
INSERT INTO `b_teletext_terminal_copy` VALUES (57, '终端2', '12-12-12-12-12-12', '1', 0, NULL, 0, '2019-04-12 15:58:52', 1, NULL, NULL, 0, '新和镇;新和社区居委会;庆合村委会;通康村委会;作字村委会;兰山村委会;岜岩村委会;');

-- ----------------------------
-- Table structure for b_transmitter_info
-- ----------------------------
DROP TABLE IF EXISTS `b_transmitter_info`;
CREATE TABLE `b_transmitter_info`  (
  `f_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '记录序号',
  `f_adapter_id` int(20) NULL DEFAULT NULL COMMENT '适配器Id',
  `f_transmitter_id` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发射机编号',
  `f_transmitter_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发射机名称',
  `f_adapter_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '绑定适配器（选择前端设备中录入的适配器）',
  `f_region` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属区域',
  `f_install_area` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '安装地址',
  `f_physical_code` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '物理编码',
  `f_resourcecode` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '资源编码',
  `f_transmitter_state` int(1) NULL DEFAULT NULL COMMENT '发射机状态:\r\n0:设备正常   \r\n1:AES丢失  \r\n2:外部时钟失锁\r\n3:1PPS失锁\r\n4:RF失锁\r\n5:反射功率过高\r\n6:温度过高\r\n7:输出功率过低\r\n',
  `f_transmitter_output_fm` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发射机输出频率，单位KHZ，如87.5MHz  按 87500KHZ进行传输',
  `f_output_power` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '输出功率，单位W，以浮点型整数进行传输,精确到小数点后2位',
  `f_equipment_temperature` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备温度，单位℃，以浮点型整数进行传输,精确到小数点后2位',
  `f_transmitter_voltage` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发射机工作电压，单位V，以浮点型整数进行传输,精确到小数点后2位',
  `f_transmitter_current` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发射机工作电流，单位A，以浮点型整数进行传输,精确到小数点后2位',
  `f_transmitter_reflection_power` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发射机反射功率，单位W, 以浮点型整数进行传输,精确到小数点后2位',
  `f_left_channel_modulation` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '左声道调制度，单位KHZ，以浮点型整数进行传输,精确到小数点后2位',
  `f_right_channel_modulation` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '右声道调制度，单位KHZ，以浮点型整数进行传输,精确到小数点后2位',
  `f_harmonic_channel_modulation` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '和声道调制度，单位KHZ，以浮点型整数进行传输,精确到小数点后2位',
  `f_differential_channel_modulation` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '差声道调制度，单位KHZ，以浮点型整数进行传输,精确到小数点后2位',
  `f_rf_lock_state` int(1) NULL DEFAULT NULL COMMENT 'RF锁定状态，1:失锁   0:锁定',
  `pll_lock_state` int(1) NULL DEFAULT NULL COMMENT 'PLL锁定状态，1:失锁   0:锁定',
  `f_back_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '回传时间',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_transmitter_info
-- ----------------------------
INSERT INTO `b_transmitter_info` VALUES (1, 524, '1', '1', '1', '1', '1', '11', '061245140210220301', 1, '1', '1', '1', '1', '1', '1', '1', '1', '1', '1', 1, 1, '1');

-- ----------------------------
-- Table structure for b_update_file
-- ----------------------------
DROP TABLE IF EXISTS `b_update_file`;
CREATE TABLE `b_update_file`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_number` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件编号',
  `f_file_name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件名称',
  `f_file_address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '文件地址',
  `f_manufacturer_number` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '厂商编号',
  `f_device_type` int(11) NULL DEFAULT NULL COMMENT '设备类型',
  `f_hardware_version` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '硬件版本',
  `f_old_software_version` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '旧软件版本号',
  `f_software_version` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新软件版本号',
  `f_broadcast_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播发区域表关联主键',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_update_flag` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '可升级标志',
  `f_delete_flag` tinyint(1) UNSIGNED ZEROFILL NULL DEFAULT 0 COMMENT '删除标志',
  `f_update_type` tinyint(4) UNSIGNED ZEROFILL NULL DEFAULT 0000 COMMENT '升级模式（0：强行升级，不比对版本号； 1：高版本升级，当新软件版本比现有终 端版本高时执行软件升级； 2：给指定版本升级，终端版软件本与指 定的版本（旧软件版本）一致时才升级 到新版本。）',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '设备升级表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for b_video_ads
-- ----------------------------
DROP TABLE IF EXISTS `b_video_ads`;
CREATE TABLE `b_video_ads`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_video_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '视频名称',
  `f_address` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '地址',
  `f_send_all_dates` tinyint(1) NULL DEFAULT NULL COMMENT '是否发送所有日期',
  `f_send_start_date` date NULL DEFAULT NULL COMMENT '发送开始日期',
  `f_send_end_date` date NULL DEFAULT NULL COMMENT '发送结束日期',
  `f_send_all_times` tinyint(1) NULL DEFAULT NULL COMMENT '是否发送所有时间',
  `f_send_start_time` time(0) NULL DEFAULT NULL COMMENT '发送开始时间',
  `f_send_end_time` time(0) NULL DEFAULT NULL COMMENT '发送结束时间',
  `f_broadcast_area` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '播发区域',
  `f_remark` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  `f_state` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '发布为1，停止为0',
  `f_device` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '终端设备',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '视频广告表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of b_video_ads
-- ----------------------------
INSERT INTO `b_video_ads` VALUES (8, '测试视频2', '', NULL, '2019-01-28', '2019-02-05', NULL, '12:12:56', '15:12:56', '2,38,39', '士大夫', 0, '2019-01-28 12:13:07', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_video_ads` VALUES (9, '测试视频4', '', NULL, '2019-01-28', '2019-02-19', NULL, '12:16:41', '15:16:41', '38,3,4,5', '地方', 0, '2019-01-28 12:16:59', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_video_ads` VALUES (10, '测试2', '', NULL, '2019-01-28', '2019-02-13', NULL, '15:45:52', '23:45:52', '10,11', '地方2', 0, '2019-01-28 15:46:04', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_video_ads` VALUES (11, '测试99', '3,4,5', NULL, '2019-01-28', '2019-02-14', NULL, '15:47:16', '18:47:16', '3,4,5', '', 0, '2019-01-28 15:47:29', 1, '2019-02-14 16:58:02', 1, 1, '0', NULL);
INSERT INTO `b_video_ads` VALUES (12, '测试36', 'http://10.177.3.189:8080/upload/other/b8d9c917-1300-40f1-a2ed-33d3afae8ee1.avi', NULL, '2019-02-15', '2019-03-23', NULL, '16:10:30', '22:10:33', '260', '啊啊啊', 0, '2019-02-15 16:10:39', 1, '2019-03-23 03:57:50', 1, 1, '0', NULL);
INSERT INTO `b_video_ads` VALUES (13, '测试345', '', NULL, '2019-04-05', '2019-04-06', NULL, '19:43:41', '21:43:41', '151', '', 0, '2019-04-05 18:43:51', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_video_ads` VALUES (14, '水水灌灌', '', NULL, '2019-04-06', '2019-04-07', NULL, '17:40:36', '18:40:36', '150,151,155,156,157,158,159', '发的发的发', 0, '2019-04-06 16:40:46', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_video_ads` VALUES (15, 'vvdsfs', '', NULL, NULL, NULL, NULL, NULL, NULL, '151', NULL, 0, '2019-04-07 20:20:58', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_video_ads` VALUES (16, 'fdgd', '', NULL, NULL, NULL, NULL, NULL, NULL, '162', NULL, 0, '2019-04-07 20:22:28', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_video_ads` VALUES (17, 'fsdf', '', NULL, NULL, NULL, NULL, NULL, NULL, '151', NULL, 0, '2019-04-07 20:27:01', 1, NULL, 1, 1, '0', NULL);
INSERT INTO `b_video_ads` VALUES (18, '测试二', 'http://10.177.3.205:8080/upload/other\\46f8dd41-03b1-4bb7-8c65-ef6ed001094b.mp4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-11 20:50:09', 1, '2019-04-11 20:54:54', 1, 1, '0', '终端1;终端6;终端8;');
INSERT INTO `b_video_ads` VALUES (19, '测试一', 'http://10.177.3.205:8080/upload/other\\32fff6dd-3afa-4f26-8dcd-68b11beba395.mp4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-11 20:58:45', 1, NULL, 1, 1, '0', '终端1;终端2;');
INSERT INTO `b_video_ads` VALUES (20, '测试3', '', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-15 16:47:33', 1, NULL, 1, 1, '0', '终端1,终端2,终端3');
INSERT INTO `b_video_ads` VALUES (21, '十七', 'http://10.177.3.143:8080/upload/other/a886a4b1-cf3e-493e-8e1b-3a83cda10ed9.mp4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-16 12:19:46', 1, NULL, 1, 1, '0', '图文终端');
INSERT INTO `b_video_ads` VALUES (23, '星空', 'http://10.177.3.143:8080/upload/other/08e01c7b-527b-48aa-8cf0-ac2c1f929c43.mp4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-16 20:02:21', 1, NULL, 1, 1, '0', '图文终端');
INSERT INTO `b_video_ads` VALUES (24, '以父之名', 'http://10.177.3.143:8080/upload/other/e5f06fa5-9c86-4ad6-bc5e-95f9a1eaae2a.mp4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-17 20:59:59', 1, NULL, 1, 1, '0', '图文终端');
INSERT INTO `b_video_ads` VALUES (25, '1', 'http://10.177.3.143:8080/upload/other/c262dfad-4ebe-4c37-98b8-54a87ba96d76.mp4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-18 17:23:11', 1, NULL, NULL, 0, '0', '图文终端');
INSERT INTO `b_video_ads` VALUES (26, '父', 'http://10.177.3.143:8080/upload/other/f12ad648-664e-4588-8e71-d66304d6907d.mp4', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 0, '2019-04-18 17:28:08', 1, NULL, NULL, 0, '0', '图文终端');

-- ----------------------------
-- Table structure for b_whitelist
-- ----------------------------
DROP TABLE IF EXISTS `b_whitelist`;
CREATE TABLE `b_whitelist`  (
  `f_id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `f_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '所有者姓名',
  `f_telephone_number` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '电话号码',
  `f_control_device` int(10) NULL DEFAULT NULL COMMENT '设备id',
  `f_permit` tinyint(4) NULL DEFAULT NULL COMMENT '授权方式（1 电话，2短信，3都有）',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `f_creator_id` int(10) NULL DEFAULT NULL COMMENT '创建者id',
  `f_operator_id` int(10) NULL DEFAULT NULL COMMENT '操作者id',
  `f_area` varchar(4000) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '所属区域id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci COMMENT = '白名单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `BLOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `SCHED_NAME`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CALENDAR` blob NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `CRON_EXPRESSION` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TIME_ZONE_ID` varchar(80) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ENTRY_ID` varchar(95) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `FIRED_TIME` bigint(13) NOT NULL,
  `SCHED_TIME` bigint(13) NOT NULL,
  `PRIORITY` int(11) NOT NULL,
  `STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `ENTRY_ID`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TRIG_INST_NAME`(`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_FT_INST_JOB_REQ_RCVRY`(`SCHED_NAME`, `INSTANCE_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_FT_J_G`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_T_G`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_FT_TG`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `JOB_CLASS_NAME` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_DURABLE` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_NONCONCURRENT` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `IS_UPDATE_DATA` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REQUESTS_RECOVERY` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_J_REQ_RECOVERY`(`SCHED_NAME`, `REQUESTS_RECOVERY`) USING BTREE,
  INDEX `IDX_QRTZ_J_GRP`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOCK_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `LOCK_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('broadcast_schedule', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `INSTANCE_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LAST_CHECKIN_TIME` bigint(13) NOT NULL,
  `CHECKIN_INTERVAL` bigint(13) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `INSTANCE_NAME`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `REPEAT_COUNT` bigint(7) NOT NULL,
  `REPEAT_INTERVAL` bigint(12) NOT NULL,
  `TIMES_TRIGGERED` bigint(10) NOT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `STR_PROP_1` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_2` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `STR_PROP_3` varchar(512) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `INT_PROP_1` int(11) NULL DEFAULT NULL,
  `INT_PROP_2` int(11) NULL DEFAULT NULL,
  `LONG_PROP_1` bigint(20) NULL DEFAULT NULL,
  `LONG_PROP_2` bigint(20) NULL DEFAULT NULL,
  `DEC_PROP_1` decimal(13, 4) NULL DEFAULT NULL,
  `DEC_PROP_2` decimal(13, 4) NULL DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers`  (
  `SCHED_NAME` varchar(120) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `JOB_GROUP` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `DESCRIPTION` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `NEXT_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PREV_FIRE_TIME` bigint(13) NULL DEFAULT NULL,
  `PRIORITY` int(11) NULL DEFAULT NULL,
  `TRIGGER_STATE` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `TRIGGER_TYPE` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `START_TIME` bigint(13) NOT NULL,
  `END_TIME` bigint(13) NULL DEFAULT NULL,
  `CALENDAR_NAME` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `MISFIRE_INSTR` smallint(2) NULL DEFAULT NULL,
  `JOB_DATA` blob NULL,
  PRIMARY KEY (`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_J`(`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_JG`(`SCHED_NAME`, `JOB_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_C`(`SCHED_NAME`, `CALENDAR_NAME`) USING BTREE,
  INDEX `IDX_QRTZ_T_G`(`SCHED_NAME`, `TRIGGER_GROUP`) USING BTREE,
  INDEX `IDX_QRTZ_T_STATE`(`SCHED_NAME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_STATE`(`SCHED_NAME`, `TRIGGER_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_N_G_STATE`(`SCHED_NAME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NEXT_FIRE_TIME`(`SCHED_NAME`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST`(`SCHED_NAME`, `TRIGGER_STATE`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_STATE`) USING BTREE,
  INDEX `IDX_QRTZ_T_NFT_ST_MISFIRE_GRP`(`SCHED_NAME`, `MISFIRE_INSTR`, `NEXT_FIRE_TIME`, `TRIGGER_GROUP`, `TRIGGER_STATE`) USING BTREE,
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) REFERENCES `qrtz_job_details` (`SCHED_NAME`, `JOB_NAME`, `JOB_GROUP`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_administrative_division
-- ----------------------------
DROP TABLE IF EXISTS `t_administrative_division`;
CREATE TABLE `t_administrative_division`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `f_code` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码',
  `f_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '名称',
  `f_longitude` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '经度',
  `f_latitude` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '纬度',
  `f_parent_node` int(10) UNSIGNED NULL DEFAULT 0 COMMENT '父节点',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 288 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '行政区域表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_administrative_division
-- ----------------------------
INSERT INTO `t_administrative_division` VALUES (1, '451031000000', '隆林各族自治县', '105.342363', '24.774318', 0, NULL, '2018-12-22 15:55:33', 1, '2019-02-21 19:07:02', 1, 1);
INSERT INTO `t_administrative_division` VALUES (2, '451031000000', '蛇场乡', '105.283', '24.5786', 1, 0, '2018-12-22 15:55:33', 1, '2019-02-21 19:06:52', 1, 1);
INSERT INTO `t_administrative_division` VALUES (3, '451031000000', '革步乡', '105.054', '24.6847', 1, 1, '2018-12-22 15:55:33', 1, '2019-02-21 19:06:52', 1, 1);
INSERT INTO `t_administrative_division` VALUES (4, '451031000000', '金钟山乡', '104.83', '24.6401', 1, 2, '2018-12-22 15:55:33', 1, '2019-02-21 19:06:52', 1, 1);
INSERT INTO `t_administrative_division` VALUES (5, '451402102203', '者浪乡', '105.201', '24.8343', 1, 3, '2018-12-22 15:55:33', 1, '2019-02-21 19:06:52', 1, 1);
INSERT INTO `t_administrative_division` VALUES (6, '451402102202', '岩茶乡', '105.484', '24.5708', 1, 4, '2018-12-22 15:55:33', 1, '2019-02-21 19:06:52', 1, 1);
INSERT INTO `t_administrative_division` VALUES (7, '451031000000', '德峨镇', '105.169', '24.732', 1, 5, '2018-12-22 15:55:33', 1, '2019-02-21 19:06:52', 1, 1);
INSERT INTO `t_administrative_division` VALUES (8, '451031000000', '新州镇', '105.318', '24.7642', 1, 6, '2018-12-22 15:55:33', 1, NULL, NULL, 1);
INSERT INTO `t_administrative_division` VALUES (9, '451031000000', '隆或镇', '105.509', '24.6445', 1, 7, '2018-12-22 15:55:33', 1, NULL, NULL, 1);
INSERT INTO `t_administrative_division` VALUES (10, '451031000000', '桠杈镇', '105.203', '24.8885', 1, 8, '2018-12-22 15:55:33', 1, NULL, NULL, 1);
INSERT INTO `t_administrative_division` VALUES (11, '451031000000', '克长乡', '105.301', '24.678', 1, 9, '2018-12-22 15:55:33', 1, NULL, NULL, 1);
INSERT INTO `t_administrative_division` VALUES (12, '451031000000', '平班镇', '105.429', '24.8374', 1, 10, '2018-12-22 15:55:33', 1, NULL, NULL, 1);
INSERT INTO `t_administrative_division` VALUES (13, '451031000000', '介廷乡', '105.602', '24.5642', 1, 11, '2018-12-22 15:55:33', 1, NULL, NULL, 1);
INSERT INTO `t_administrative_division` VALUES (14, '451031000000', '沙梨乡', '105.583', '24.6819', 1, 12, '2018-12-22 15:55:33', 1, NULL, NULL, 1);
INSERT INTO `t_administrative_division` VALUES (15, '451402102203', '猪场乡', '105.149', '24.7522', 1, 13, '2018-12-22 15:55:33', 1, NULL, NULL, 1);
INSERT INTO `t_administrative_division` VALUES (16, '451031000000', '者保乡', '105.337', '24.8286', 1, 14, '2018-12-22 15:55:33', 1, NULL, NULL, 1);
INSERT INTO `t_administrative_division` VALUES (17, '451031000000', '天生桥镇', '105.186', '24.8157', 1, 15, '2018-12-22 15:55:33', 1, '2018-12-28 22:02:38', 1, 1);
INSERT INTO `t_administrative_division` VALUES (21, '451402104212', '省级平台', NULL, NULL, 1, NULL, '2019-02-19 16:09:40', 1, '2019-02-21 19:06:52', 1, 1);
INSERT INTO `t_administrative_division` VALUES (40, '451031210000', '者浪乡', '105.2014', '24.8343', 1, 1, '2019-01-27 22:02:59', 1, NULL, NULL, NULL);
INSERT INTO `t_administrative_division` VALUES (41, '451031220000', '者浪乡1', '105.2014', '24.8343', 1, 1, '2019-01-27 22:05:16', 1, NULL, NULL, NULL);
INSERT INTO `t_administrative_division` VALUES (42, '451031230000', '者浪乡1', '105.2014', '24.8343', 1, 1, '2019-01-27 22:06:25', 1, NULL, NULL, NULL);
INSERT INTO `t_administrative_division` VALUES (43, '451031240000', '者浪乡1', '105.2014', '24.8343', 1, 1, '2019-01-27 22:07:18', 1, NULL, NULL, NULL);
INSERT INTO `t_administrative_division` VALUES (44, '451031250000', '者浪乡1', '105.2014', '24.8343', 1, 1, '2019-01-27 22:07:48', 1, NULL, NULL, NULL);
INSERT INTO `t_administrative_division` VALUES (45, '451031260000', '者浪乡1', '105.2014', '24.8343', 1, 1, '2019-01-27 22:09:42', 1, NULL, NULL, NULL);
INSERT INTO `t_administrative_division` VALUES (46, '451031270000', '者浪乡1', '105.2014', '24.8343', 1, 1, '2019-01-27 22:10:17', 1, NULL, NULL, NULL);
INSERT INTO `t_administrative_division` VALUES (48, '451031280000', '者浪乡1', '105.2014', '24.8343', 1, 1, '2019-01-27 22:14:26', 1, '2019-01-27 22:15:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (49, '451031280000', '者浪乡1', '105.2014', '24.8343', 1, 1, '2019-01-27 22:15:47', 1, '2019-01-27 22:16:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (50, '451031280000', '者浪乡1', '105.2014', '24.8343', 1, 1, '2019-01-27 22:16:38', 1, '2019-01-27 22:16:42', 1, 1);
INSERT INTO `t_administrative_division` VALUES (51, '451031280000', '者浪乡1', '105.2014', '24.8343', 1, 1, '2019-01-27 22:19:42', 1, '2019-01-27 22:21:10', 1, 1);
INSERT INTO `t_administrative_division` VALUES (52, '451032000000', '隆林各族自治县', '105.2014', '24.8343', 0, 1, '2019-01-27 22:21:15', 1, '2019-01-27 22:21:43', 1, 1);
INSERT INTO `t_administrative_division` VALUES (53, '451032270000', '者浪乡2', '105.2014', '24.8343', 52, 1, '2019-01-27 22:21:15', 1, '2019-01-27 22:21:43', 1, 1);
INSERT INTO `t_administrative_division` VALUES (54, '451032270001', '11', '105.2014', '24.8343', 53, 1, '2019-01-27 22:21:15', 1, '2019-01-27 22:21:43', 1, 1);
INSERT INTO `t_administrative_division` VALUES (55, '451032270002', '11', '105.2014', '24.8343', 53, 1, '2019-01-27 22:21:15', 1, '2019-01-27 22:21:43', 1, 1);
INSERT INTO `t_administrative_division` VALUES (56, '451032270003', '11', '105.2014', '24.8343', 53, 1, '2019-01-27 22:21:15', 1, '2019-01-27 22:21:43', 1, 1);
INSERT INTO `t_administrative_division` VALUES (57, '451032280000', '者浪乡3', '105.2014', '24.8343', 52, 1, '2019-01-27 22:21:15', 1, '2019-01-27 22:21:43', 1, 1);
INSERT INTO `t_administrative_division` VALUES (58, '451031000001', '11', '105.171763', '24.614129', 2, NULL, '2019-01-28 16:05:40', 1, '2019-01-28 16:48:29', 1, 1);
INSERT INTO `t_administrative_division` VALUES (59, '451031000002', '22', '105.119578', '24.627862', 2, NULL, '2019-01-28 16:06:16', 1, '2019-01-28 16:48:31', 1, 1);
INSERT INTO `t_administrative_division` VALUES (60, '451031002001', '蛇测试村', '105.306346', '24.517662', 2, 1, '2019-02-17 10:44:38', 1, '2019-02-17 10:46:14', 1, 1);
INSERT INTO `t_administrative_division` VALUES (129, '410704000000', '凤泉区', '113.92153', '35.400663', 0, 1, '2019-02-17 03:01:17', 1, '2019-05-17 15:32:59', 1, 0);
INSERT INTO `t_administrative_division` VALUES (130, '451402100000', '太平镇', '107.454776', '22.462435', 129, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:09', 1, 1);
INSERT INTO `t_administrative_division` VALUES (131, '451402100001', '新民社区居委会', '114.333591', '30.519088', 130, 1, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:40', 1, 1);
INSERT INTO `t_administrative_division` VALUES (132, '451402100002', '沿山社区居委会', '114.402255', '30.568763', 130, 2, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:44', 1, 1);
INSERT INTO `t_administrative_division` VALUES (133, '451402100003', '城西社区居委会', '114.259433', '30.528552', 130, 3, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:42', 1, 1);
INSERT INTO `t_administrative_division` VALUES (134, '451402100004', '中渡社区居委会', '114.389896', '30.470572', 130, 4, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:46', 1, 1);
INSERT INTO `t_administrative_division` VALUES (135, '451402100005', '壶兴社区居委会', '114.14133', '30.58768', 130, 5, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:49', 1, 1);
INSERT INTO `t_administrative_division` VALUES (136, '451402100006', '中山社区居委会', '114.183902', '30.50844', 130, 6, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:51', 1, 1);
INSERT INTO `t_administrative_division` VALUES (137, '451402100201', '卜寨村委会', '114.211368', '30.54866', 130, 7, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:53', 1, 1);
INSERT INTO `t_administrative_division` VALUES (138, '451402100202', '大村村委会', '114.273166', '30.496608', 130, 8, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:35', 1, 1);
INSERT INTO `t_administrative_division` VALUES (139, '451402100203', '卜利村委会', '114.199008', '30.600683', 130, 9, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:32', 1, 1);
INSERT INTO `t_administrative_division` VALUES (140, '451402100204', '驮逐村委会', '114.238834', '30.522637', 130, 10, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:30', 1, 1);
INSERT INTO `t_administrative_division` VALUES (141, '451402100205', '公益村委会', '114.164676', '30.496608', 130, 11, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:27', 1, 1);
INSERT INTO `t_administrative_division` VALUES (142, '451402100206', '长期村委会', '114.16193', '30.603047', 130, 12, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:25', 1, 1);
INSERT INTO `t_administrative_division` VALUES (143, '451402100207', '马安村委会', '114.215488', '30.603047', 130, 13, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:22', 1, 1);
INSERT INTO `t_administrative_division` VALUES (144, '451402100208', '宜村村委会', '114.435214', '30.608957', 130, 14, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:20', 1, 1);
INSERT INTO `t_administrative_division` VALUES (145, '451402100209', '乙古村委会', '114.289646', '30.566398', 130, 15, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:18', 1, 1);
INSERT INTO `t_administrative_division` VALUES (146, '451402100210', '古坡村委会', '114.373416', '30.541563', 130, 16, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:15', 1, 1);
INSERT INTO `t_administrative_division` VALUES (147, '451402100211', '盆峒村委会', '114.201755', '30.507257', 130, 17, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:13', 1, 1);
INSERT INTO `t_administrative_division` VALUES (148, '451402100212', '孔甲村委会', '114.186649', '30.591227', 130, 18, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:10', 1, 1);
INSERT INTO `t_administrative_division` VALUES (149, '451402100213', '渠显村委会', '114.233341', '30.515539', 130, 19, '2019-02-17 03:01:17', 1, '2019-02-21 17:46:07', 1, 1);
INSERT INTO `t_administrative_division` VALUES (150, '410704103000', '耿黄镇', '113.938696', '35.405351', 129, 2, '2019-02-17 03:01:17', 1, '2019-05-17 15:33:25', 1, 0);
INSERT INTO `t_administrative_division` VALUES (151, '410704103101', '耿庄村', '113.885138', '35.395276', 150, 3, '2019-02-17 03:01:17', 1, '2019-05-17 15:33:48', 1, 0);
INSERT INTO `t_administrative_division` VALUES (152, '451402101201', '那颜村委会', NULL, NULL, 150, NULL, '2019-02-17 03:01:17', 1, '2019-02-26 19:19:37', 1, 1);
INSERT INTO `t_administrative_division` VALUES (153, '451402101202', '新村村委会', NULL, NULL, 150, NULL, '2019-02-17 03:01:17', 1, '2019-02-26 19:19:37', 1, 1);
INSERT INTO `t_administrative_division` VALUES (154, '451402101203', '卜花村委会', NULL, NULL, 150, NULL, '2019-02-17 03:01:17', 1, '2019-02-26 19:19:37', 1, 1);
INSERT INTO `t_administrative_division` VALUES (155, '410704103102', '南张门村', '113.912604', '35.389679', 150, 4, '2019-02-17 03:01:17', 1, '2019-05-17 15:33:58', 1, 0);
INSERT INTO `t_administrative_division` VALUES (156, '451402101205', '通康村委会', NULL, NULL, 150, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (157, '451402101206', '作字村委会', '114.501819', '30.646347', 150, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (158, '451402101207', '兰山村委会', NULL, NULL, 150, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (159, '451402101208', '岜岩村委会', NULL, NULL, 150, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (160, '451402102000', '濑湍镇', '107.503528', '22.47235', 129, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (161, '451402102001', '濑湍社区居委会', NULL, NULL, 160, NULL, '2019-02-17 03:01:17', 1, '2019-02-26 19:49:48', 1, 1);
INSERT INTO `t_administrative_division` VALUES (162, '451402102201', '旧街村委会', NULL, NULL, 160, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (163, '451402102202', '岜羊村委会', NULL, NULL, 160, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (164, '451402102203', '六京村委会', '107.507305', '22.433877', 160, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (165, '451402102204', '板兰村委会', NULL, NULL, 160, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (166, '451402102205', '陇丰村委会', NULL, NULL, 160, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (167, '451402102206', '全凤村委会', NULL, NULL, 160, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (168, '451402102207', '渠凹村委会', NULL, NULL, 160, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (169, '451402102208', '仁良村委会', NULL, NULL, 160, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (170, '451402102209', '九岸村委会', NULL, NULL, 160, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (171, '451402102210', '叫城村委会', NULL, NULL, 160, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (172, '451402103000', '江州镇', '107.383365', '22.339278', 129, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (173, '451402103001', '江州社区居委会', NULL, NULL, 172, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (174, '451402103201', '板备村委会', NULL, NULL, 172, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (175, '451402103202', '保安村委会', NULL, NULL, 172, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (176, '451402103203', '板麦村委会', NULL, NULL, 172, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (177, '451402103204', '卜松村委会', NULL, NULL, 172, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (178, '451402103205', '卜驮村委会', NULL, NULL, 172, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (179, '451402103206', '渠座村委会', NULL, NULL, 172, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (180, '451402103207', '渌留村委会', NULL, NULL, 172, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (181, '451402103208', '那贞村委会', NULL, NULL, 172, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (182, '451402103209', '咘哝村委会', NULL, NULL, 172, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (183, '451402103210', '板崇村委会', NULL, NULL, 172, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (184, '451402103211', '那么村委会', NULL, NULL, 172, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (185, '451402104000', '左州镇', '107.475376', '22.698286', 129, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (186, '451402104001', '左州社区居委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (187, '451402104201', '岜模村委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (188, '451402104202', '黄村村委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (189, '451402104203', '渠西村委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (190, '451402104204', '龙合村委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (191, '451402104205', '光坡村委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (192, '451402104206', '陇念村委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (193, '451402104207', '果坡村委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (194, '451402104208', '广何村委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (195, '451402104209', '那坎村委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (196, '451402104210', '林村村委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (197, '451402104211', '中干村委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (198, '451402104212', '立村村委会', NULL, NULL, 185, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (199, '451402105000', '那隆镇', '107.831058', '22.388808', 129, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (200, '451402105001', '那隆社区居委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (201, '451402105201', '那印村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (202, '451402105202', '仁惕村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (203, '451402105203', '廷内村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-02-26 20:27:58', 1, 1);
INSERT INTO `t_administrative_division` VALUES (204, '451402105204', '群黎村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (205, '451402105205', '拾义村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (206, '451402105206', '那内村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (207, '451402105207', '发明村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (208, '451402105208', '仁里村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (209, '451402105209', '岜王村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (210, '451402105210', '那光村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (211, '451402105211', '那练村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (212, '451402105212', '必六村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (213, '451402105213', '王沙村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (214, '451402105214', '合卢村委会', NULL, NULL, 199, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (215, '451402106000', '驮卢镇', '107.679996', '22.434512', 129, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (216, '451402106001', '新兴社区居委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (217, '451402106002', '繁荣社区居委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (218, '451402106003', '雷州社区居委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (219, '451402106201', '岜白村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (220, '451402106202', '农里村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (221, '451402106203', '灶瓦村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (222, '451402106204', '伏廖村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (223, '451402106205', '那模村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (224, '451402106206', '屯村村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (225, '451402106207', '崇王村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (226, '451402106208', '更兰村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (227, '451402106209', '连塘村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (228, '451402106210', '渠邦村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (229, '451402106211', '驮目村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (230, '451402106212', '江涨村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (231, '451402106213', '渠立村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (232, '451402106214', '逐盎村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (233, '451402106215', '岑豆村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (234, '451402106216', '驮柏村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (235, '451402106217', '谭垌村委会', NULL, NULL, 215, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (236, '451402201000', '罗白乡', '107.54404', '21.969154', 129, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (237, '451402201001', '罗白社区居委会', NULL, NULL, 236, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (238, '451402201201', '岜那村委会', NULL, NULL, 236, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (239, '451402201202', '渠姆村委会', NULL, NULL, 236, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (240, '451402201203', '强胜村委会', NULL, NULL, 236, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (241, '451402201204', '渠勒村委会', NULL, NULL, 236, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (242, '451402201205', '蒙井村委会', NULL, NULL, 236, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (243, '451402201206', '那并村委会', NULL, NULL, 236, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (244, '451402201207', '岜萌村委会', NULL, NULL, 236, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (245, '451402201208', '枯隆村委会', NULL, NULL, 236, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (246, '451402202000', '板利乡', '107.530307', '22.233809', 129, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (247, '451402202001', '板利社区居委会', NULL, NULL, 246, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (248, '451402202201', '卜城村委会', NULL, NULL, 246, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (249, '451402202202', '渠麻村委会', NULL, NULL, 246, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (250, '451402202203', '那忙村委会', NULL, NULL, 246, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (251, '451402202204', '福厚村委会', NULL, NULL, 246, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (252, '451402202205', '那陶村委会', NULL, NULL, 246, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (253, '451402400000', '新和华', '106.982364', '22.518264', 129, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (254, '451402400501', '侨农场 直属分场生活区', NULL, NULL, 253, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (255, '451402400502', '侨农场 新和分场生活区', NULL, NULL, 253, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (256, '451402400503', '侨农场 通康分厂生活区', NULL, NULL, 253, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (257, '451402400504', '侨农场 岜内分厂生活区', NULL, NULL, 253, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (258, '451402400505', '侨农场 大桥分场生活区', NULL, NULL, 253, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (259, '451402400506', '侨农场 庆和分场生活区', NULL, NULL, 253, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (260, '451402400507', '侨农场 沿井分场生活区', NULL, NULL, 253, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (261, '451402400508', '侨农场 新村分场生活区', NULL, NULL, 253, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (262, '451402400509', '侨农场 狮子山分场生活区', NULL, NULL, 253, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (263, '451402400510', '侨农场 独山分场生活区', NULL, NULL, 253, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (264, '451402401000', '左江华', '106.90546', '22.292271', 129, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (265, '451402401501', '侨农场 左江华侨农场场部生活区', NULL, NULL, 264, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (266, '451402401502', '侨农场 农里分场生活区', NULL, NULL, 264, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (267, '451402401503', '侨农场 新院分场生活区', NULL, NULL, 264, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (268, '451402401504', '侨农场 里鱼山分场生活区', NULL, NULL, 264, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (269, '451402401505', '侨农场 渠拔分场生活区', NULL, NULL, 264, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (270, '451402401506', '侨农场 六旺分场生活区', NULL, NULL, 264, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (271, '451402401507', '侨农场 龙塘分场生活区', NULL, NULL, 264, NULL, '2019-02-17 03:01:17', 1, '2019-02-26 20:22:57', 1, 1);
INSERT INTO `t_administrative_division` VALUES (272, '451402401508', '侨农场 立新分场生活区', NULL, NULL, 264, NULL, '2019-02-17 03:01:17', 1, '2019-02-26 20:12:11', 1, 1);
INSERT INTO `t_administrative_division` VALUES (273, '451402401509', '侨农场 渠扶分场生活区', NULL, NULL, 264, NULL, '2019-02-17 03:01:17', 1, '2019-05-17 15:29:34', 1, 1);
INSERT INTO `t_administrative_division` VALUES (274, '451402401510', '侨农场 渠西分场生活区', NULL, NULL, 264, NULL, '2019-02-17 03:01:17', 1, '2019-02-26 19:50:21', 1, 1);
INSERT INTO `t_administrative_division` VALUES (275, '451402401511', '侨农场 岜王分场生活区', NULL, NULL, 264, NULL, '2019-02-17 03:01:17', 1, '2019-02-26 19:49:03', 1, 1);
INSERT INTO `t_administrative_division` VALUES (276, '451402401512', '侨农场 那隆分场生活区', NULL, NULL, 264, NULL, '2019-02-17 03:01:17', 1, '2019-02-26 19:48:40', 1, 1);
INSERT INTO `t_administrative_division` VALUES (278, '45140200000', '武东', '107.390406', '22.330475', 129, 2, '2019-02-26 19:26:32', 1, '2019-02-26 19:43:09', 1, 1);
INSERT INTO `t_administrative_division` VALUES (279, '451402401513', '赋那村', '105.201', '24.8343', 264, 1, '2019-02-26 19:48:23', 1, '2019-02-26 19:50:21', 1, 1);
INSERT INTO `t_administrative_division` VALUES (280, '451402401508', '武东', '107.376415', '22.389348', 129, 1, '2019-02-26 19:56:21', 1, '2019-02-26 20:12:11', 1, 1);
INSERT INTO `t_administrative_division` VALUES (281, '451402401513', '赋那村', '105.201', '24.8343', 264, 1, '2019-02-26 20:13:59', 1, '2019-02-26 20:21:47', 1, 1);
INSERT INTO `t_administrative_division` VALUES (282, '451402401514', '赋那村2', '106.201', '25.8343', 264, NULL, '2019-02-26 20:20:59', 1, '2019-02-26 20:21:51', 1, 1);
INSERT INTO `t_administrative_division` VALUES (283, '451402401515', '赋那村', '105.201', '24.8343', 264, 1, '2019-02-26 20:20:59', 1, '2019-02-26 20:23:16', 1, 1);
INSERT INTO `t_administrative_division` VALUES (284, '451402401513', '赋那村3', '107.201', '26.8343', 264, NULL, '2019-02-26 20:24:05', 1, '2019-02-26 20:24:22', 1, 1);
INSERT INTO `t_administrative_division` VALUES (285, '451402401514', '赋那村2', '106.201', '25.8343', 264, NULL, '2019-02-26 20:24:05', 1, '2019-02-26 20:24:15', 1, 1);
INSERT INTO `t_administrative_division` VALUES (286, '451402401515', '赋那村', '105.201', '24.8343', 264, 1, '2019-02-26 20:24:05', 1, '2019-02-26 20:24:31', 1, 1);
INSERT INTO `t_administrative_division` VALUES (287, '45140200000', '武东', '107.115573', '22.460353', 264, 11, '2019-03-01 18:18:27', 1, '2019-05-17 15:29:34', 1, 1);

-- ----------------------------
-- Table structure for t_alarm_principal
-- ----------------------------
DROP TABLE IF EXISTS `t_alarm_principal`;
CREATE TABLE `t_alarm_principal`  (
  `f_id` int(11) NOT NULL AUTO_INCREMENT,
  `f_principal` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `f_area` int(11) NULL DEFAULT NULL,
  `f_career` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `f_telephone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `f_sort` tinyint(4) NULL DEFAULT 0,
  `f_create_time` datetime(0) NULL DEFAULT NULL,
  `f_create_id` int(11) NULL DEFAULT NULL,
  `f_updtate_time` datetime(0) NULL DEFAULT NULL,
  `f_operator_id` int(255) NULL DEFAULT NULL,
  `f_delete_flag` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '告警负责人' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_device_channel_protocol
-- ----------------------------
DROP TABLE IF EXISTS `t_device_channel_protocol`;
CREATE TABLE `t_device_channel_protocol`  (
  `f_id` int(10) NOT NULL,
  `protocol_type` varchar(320) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_device_channel_protocol
-- ----------------------------
INSERT INTO `t_device_channel_protocol` VALUES (23, '83,84');
INSERT INTO `t_device_channel_protocol` VALUES (24, '84');
INSERT INTO `t_device_channel_protocol` VALUES (25, '82');
INSERT INTO `t_device_channel_protocol` VALUES (27, '84');

-- ----------------------------
-- Table structure for t_dictionary
-- ----------------------------
DROP TABLE IF EXISTS `t_dictionary`;
CREATE TABLE `t_dictionary`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_dictionary_type` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '字典类型',
  `f_dictionary_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典代码',
  `f_third_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '三方编码',
  `f_dictionary_content` varchar(320) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '字典内容(三方编码名称)',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 211 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '字典表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_dictionary
-- ----------------------------
INSERT INTO `t_dictionary` VALUES (7, 40, 'program_channel', '01', '话筒-线路-FM-U盘', 2, '2018-12-16 16:19:00', NULL, '2019-03-28 21:26:47', 1, 0);
INSERT INTO `t_dictionary` VALUES (8, 40, 'program_channel', '02', '文本-转-语音', 3, '2018-12-16 16:30:45', NULL, '2019-03-28 21:33:05', 1, 0);
INSERT INTO `t_dictionary` VALUES (11, 41, 'message_type', '10000', '突发事件', 1, '2018-12-16 16:41:32', NULL, '2019-02-26 19:16:06', 1, 1);
INSERT INTO `t_dictionary` VALUES (12, 42, 'message_grade ', '1', '一级(特别重大)', 1, '2018-12-17 16:04:27', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (13, 42, 'message_grade ', '2', '二级(重大)', 2, '2018-12-17 16:04:48', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (14, 42, 'message_grade ', '3', '三级(较大)', 3, '2018-12-17 16:05:01', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (15, 42, 'message_grade ', '4', '四级(一般)', 4, '2018-12-17 16:05:19', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (16, 43, 'device_channel', '1', '话筒', 1, '2018-12-17 16:08:54', NULL, '2019-02-26 20:34:07', 1, 1);
INSERT INTO `t_dictionary` VALUES (17, 43, 'device_channel', '2', '线路一', 2, '2018-12-17 16:09:05', NULL, '2019-01-06 13:49:44', 1, 0);
INSERT INTO `t_dictionary` VALUES (18, 43, 'device_channel', '3', '线路二', 3, '2018-12-17 16:09:15', NULL, '2019-01-06 13:49:46', 1, 0);
INSERT INTO `t_dictionary` VALUES (19, 43, 'device_channel', '4', 'U盘', 4, '2018-12-17 16:09:30', NULL, '2019-01-06 13:49:49', 1, 0);
INSERT INTO `t_dictionary` VALUES (20, 43, 'device_channel', '8', '文本', 5, '2018-12-17 16:09:42', NULL, '2019-01-29 16:54:35', 1, 1);
INSERT INTO `t_dictionary` VALUES (21, 41, 'message_type', '11A01', '洪水', 4, '2018-12-17 16:10:13', NULL, '2019-01-11 10:53:47', 1, 0);
INSERT INTO `t_dictionary` VALUES (22, 41, 'message_type', '11A02', '内涝', 5, '2018-12-17 16:10:38', NULL, '2019-01-11 10:53:53', 1, 0);
INSERT INTO `t_dictionary` VALUES (23, 44, 'broadcast_destinate', '1', '大喇叭', 1, '2018-12-17 16:12:05', NULL, '2018-12-21 22:51:04', 1, 0);
INSERT INTO `t_dictionary` VALUES (24, 44, 'broadcast_destinate', '3', '字幕', 3, '2018-12-17 16:12:31', NULL, '2019-02-16 22:54:40', 1, 0);
INSERT INTO `t_dictionary` VALUES (25, 44, 'broadcast_destinate', '2', '广播电视', 2, '2018-12-17 16:12:40', NULL, '2019-02-16 22:54:32', 1, 0);
INSERT INTO `t_dictionary` VALUES (27, 44, 'broadcast_destinate', '4', '新媒体', 4, '2018-12-17 16:13:24', NULL, '2019-02-19 10:18:10', 1, 0);
INSERT INTO `t_dictionary` VALUES (28, 45, 'streaming_media_type', '3', 'MP3', 1, '2018-12-17 16:51:54', NULL, '2019-03-01 19:29:10', 1, 0);
INSERT INTO `t_dictionary` VALUES (29, 45, 'streaming_media_type', '', 'MP2', 2, '2018-12-17 16:52:10', NULL, '2019-02-21 15:59:02', 1, 0);
INSERT INTO `t_dictionary` VALUES (30, 45, 'streaming_media_type', NULL, '音频流', 3, '2018-12-17 16:52:32', NULL, '2019-02-16 22:49:47', 1, 1);
INSERT INTO `t_dictionary` VALUES (31, 45, 'streaming_media_type', '', 'AAC', 3, '2018-12-17 16:52:41', NULL, '2019-02-21 15:59:04', 1, 0);
INSERT INTO `t_dictionary` VALUES (40, 0, 'program_channel', NULL, '节目通道', 5, '2018-12-19 20:54:25', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (41, 0, 'message_type', NULL, '消息类型', 10, '2018-12-19 20:54:26', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (42, 0, 'message_grade ', NULL, '消息级别', 20, '2018-12-19 20:54:26', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (43, 0, 'device_channel', NULL, '设备通道', 30, '2018-12-19 20:54:26', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (44, 0, 'broadcast_destinate', NULL, '播发去向', 40, '2018-12-19 20:54:26', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (45, 0, 'streaming_media_type', NULL, '流媒体类型', 50, '2018-12-19 20:54:26', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (46, 0, 'drill_categories', NULL, '演练类型', 60, '2018-12-19 20:54:26', NULL, NULL, NULL, 1);
INSERT INTO `t_dictionary` VALUES (47, 0, 'audio_file', NULL, '音频类型', 70, '2018-12-19 20:54:26', NULL, NULL, NULL, 1);
INSERT INTO `t_dictionary` VALUES (63, 50, 'device_model', NULL, '海康摄像头', 1, '2019-01-02 17:50:25', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (64, 50, 'device_model', NULL, '大华NVR', 2, '2019-01-02 17:52:00', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (65, 50, 'device_model', NULL, '海康NVR', 3, '2019-01-02 17:52:10', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (66, 50, 'device_model', NULL, '大华摄像头', 4, '2019-01-02 17:52:27', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (68, 51, 'channel_model', NULL, '模拟通道', 0, '2019-01-02 17:55:54', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (69, 51, 'channel_model', NULL, '数字通道', 0, '2019-01-02 17:56:03', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (70, 51, 'channel_model', NULL, '零通道', 0, '2019-01-02 17:56:17', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (71, 0, 'frontDevice_model', NULL, '前端设备类型', 80, '2019-01-08 14:34:14', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (72, 71, 'frontDevice_model', '01', '县级适配器', 1, '2019-01-08 14:35:28', NULL, '2019-03-27 06:20:26', 1, 0);
INSERT INTO `t_dictionary` VALUES (73, 71, 'frontDevice_model', '01', '镇级适配器', 2, '2019-01-08 14:35:43', NULL, '2019-03-27 06:20:32', 1, 0);
INSERT INTO `t_dictionary` VALUES (74, 71, 'frontDevice_model', '01', '村级适配器', 3, '2019-01-08 14:36:10', NULL, '2019-03-27 06:20:38', 1, 0);
INSERT INTO `t_dictionary` VALUES (75, 71, 'frontDevice_model', '', '播控服务器', 4, '2019-01-08 14:36:21', NULL, '2019-03-27 06:20:46', 1, 0);
INSERT INTO `t_dictionary` VALUES (76, 0, 'terminalDevice_model', NULL, '终端设备类型', 90, '2019-01-08 14:48:44', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (77, 76, 'terminalDevice_model', '', 'sss猪', 1, '2019-01-08 14:49:58', NULL, '2019-03-01 16:41:41', 1, 1);
INSERT INTO `t_dictionary` VALUES (78, 76, 'terminalDevice_model', '01', '智能音柱', 1, '2019-01-08 14:50:19', NULL, '2019-03-27 06:19:50', 1, 0);
INSERT INTO `t_dictionary` VALUES (79, 76, 'terminalDevice_model', '01', '收扩机', 2, '2019-01-08 14:50:21', NULL, '2019-03-27 06:20:01', 1, 0);
INSERT INTO `t_dictionary` VALUES (80, 76, 'terminalDevice_model', NULL, '适配器', 4, '2019-01-08 14:50:43', NULL, '2019-02-17 20:40:05', 1, 1);
INSERT INTO `t_dictionary` VALUES (81, 0, 'protocol_type', NULL, '协议类型', 100, '2019-01-08 14:56:10', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (82, 81, 'protocol_type', NULL, 'DVB-C TS', 2, '2019-01-08 14:56:31', NULL, '2019-02-16 22:41:59', 1, 1);
INSERT INTO `t_dictionary` VALUES (83, 81, 'protocol_type', '', 'RDS', 3, '2019-01-08 14:56:42', NULL, '2019-02-21 15:59:40', 1, 0);
INSERT INTO `t_dictionary` VALUES (84, 81, 'protocol_type', '', 'IP', 2, '2019-01-08 14:56:49', NULL, '2019-02-21 15:59:38', 1, 0);
INSERT INTO `t_dictionary` VALUES (85, 41, 'message_type', '11000', '自然灾害', 2, '2019-01-11 10:52:30', 1, '2019-01-11 10:53:25', 1, 0);
INSERT INTO `t_dictionary` VALUES (86, 41, 'message_type', '11A00', '水旱灾害', 3, '2019-01-11 10:52:45', 1, '2019-01-11 10:53:31', 1, 0);
INSERT INTO `t_dictionary` VALUES (87, 41, 'message_type', '11A03', '水库重大险情', 6, '2019-01-11 10:54:09', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (88, 41, 'message_type', '11A04', '堤防重大险情', 7, '2019-01-11 10:54:21', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (89, 41, 'message_type', '11A05', '凌汛灾害', 8, '2019-01-11 10:54:33', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (90, 41, 'message_type', '11A51', '山洪灾害事件', 9, '2019-01-11 10:54:45', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (91, 41, 'message_type', '11A52', '农业干旱', 10, '2019-01-11 10:54:57', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (92, 41, 'message_type', '11A53', '城镇缺水', 11, '2019-01-11 10:55:08', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (93, 41, 'message_type', '11A54', '生态干旱', 12, '2019-01-11 10:55:45', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (94, 41, 'message_type', '11A10', '农村人畜饮水困难', 13, '2019-01-11 10:55:58', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (95, 41, 'message_type', '11A99', '其它水旱灾害', 14, '2019-01-11 10:56:12', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (96, 41, 'message_type', '11B00', '气象灾害', 15, '2019-01-11 10:56:22', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (97, 41, 'message_type', '11B01', '台风事件', 16, '2019-01-12 11:13:54', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (98, 41, 'message_type', '11B02', '龙卷风事件', 17, '2019-01-12 11:14:09', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (99, 41, 'message_type', '11B03', '暴雨事件', 18, '2019-01-12 11:14:32', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (100, 41, 'message_type', '11B04', '暴雪事件', 19, '2019-01-12 11:14:47', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (101, 41, 'message_type', '11B05', '寒潮事件', 20, '2019-01-12 11:15:03', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (102, 0, 'broadcast_type', NULL, '广播类型', 0, '2019-01-12 12:04:05', NULL, NULL, NULL, 1);
INSERT INTO `t_dictionary` VALUES (103, 102, 'broadcast_type', '1', '发布系统演练', 1, '2019-01-12 12:08:10', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (104, 102, 'broadcast_type', '2', '模拟演练', 2, '2019-01-12 12:08:20', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (105, 102, 'broadcast_type', '3', '实际演练', 3, '2019-01-12 12:08:30', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (106, 102, 'broadcast_type', '4', '应急广播', 4, '2019-01-12 12:08:40', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (107, 102, 'broadcast_type', '5', '日常广播', 5, '2019-01-12 12:08:50', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (108, 102, 'broadcast_type', '6', '升级广播', 6, '2019-01-12 12:09:00', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (109, 43, 'device_channel', '5', '调频一', 5, '2019-01-13 12:24:41', 1, '2019-02-19 10:17:47', 1, 0);
INSERT INTO `t_dictionary` VALUES (110, 43, 'device_channel', '6', '调频二', 6, '2019-01-14 15:56:37', 1, '2019-02-19 10:17:58', 1, 0);
INSERT INTO `t_dictionary` VALUES (111, 43, 'device_channel', '7', '电话短信', 8, '2019-01-21 15:59:22', NULL, '2019-01-29 16:54:43', 1, 1);
INSERT INTO `t_dictionary` VALUES (112, 0, 'pid', NULL, '基本PID', 110, '2019-01-24 13:32:07', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (140, 71, 'frontDevice_model', '', '电话网关', 6, '2019-02-16 15:15:39', 1, '2019-05-17 12:35:28', 1, 0);
INSERT INTO `t_dictionary` VALUES (147, 40, 'program_channel', '00', '县级平台', 1, '2019-02-17 09:06:04', 1, '2019-03-28 21:26:25', 1, 0);
INSERT INTO `t_dictionary` VALUES (150, 149, 'resource_type', '0103', '县平台', 1, '2019-02-17 10:58:12', 1, '2019-02-19 21:32:31', 1, 0);
INSERT INTO `t_dictionary` VALUES (151, 81, 'protocol_type', '', 'TS', 1, '2019-02-16 22:38:15', 1, '2019-02-21 15:59:37', 1, 0);
INSERT INTO `t_dictionary` VALUES (153, 149, 'resource_type', '0612', '适配器', 2, '2019-02-16 23:03:19', 1, '2019-02-19 21:32:37', 1, 0);
INSERT INTO `t_dictionary` VALUES (154, 149, 'resource_type', '0612', '终端', 3, '2019-02-16 23:03:34', 1, '2019-02-19 21:32:45', 1, 0);
INSERT INTO `t_dictionary` VALUES (158, 41, 'message_type', '00000', '省级平台测试', 21, '2019-02-19 02:52:02', 1, '2019-02-19 02:52:12', 1, 0);
INSERT INTO `t_dictionary` VALUES (162, 0, 'modulation_mode', NULL, '调制参数', 4, '2019-02-20 12:20:02', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (163, 162, 'modulation_mode', '1', 'ServiceID', 3, '2019-02-20 12:22:08', 1, '2019-03-04 12:22:32', 1, 0);
INSERT INTO `t_dictionary` VALUES (164, 162, 'modulation_mode', '1', 'PCRPID', 4, '2019-02-20 12:22:28', 1, '2019-02-26 19:53:44', 1, 0);
INSERT INTO `t_dictionary` VALUES (165, 162, 'modulation_mode', '05060000041003FFFFFFFF', 'DTMB', 1, '2019-02-20 12:25:08', 1, '2019-02-27 15:20:43', 1, 0);
INSERT INTO `t_dictionary` VALUES (166, 162, 'modulation_mode', '04080000FFF00268750000', 'DVB-C', 2, '2019-02-20 12:25:28', 1, '2019-02-27 15:20:49', 1, 0);
INSERT INTO `t_dictionary` VALUES (176, 41, 'message_type', '10000', '突发事件', 1, '2019-02-26 19:16:22', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (181, 43, 'device_channel', '1', '话筒', 1, '2019-02-26 20:33:59', 1, '2019-03-01 16:42:13', 1, 0);
INSERT INTO `t_dictionary` VALUES (198, 162, 'modulation_mode', '1', 'TSID', 5, '2019-03-08 04:13:30', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (199, 112, 'pid', '', '1100', 1, '2019-03-10 17:20:01', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (200, 112, 'pid', '', '1200', 2, '2019-04-02 21:19:03', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (201, 112, 'pid', '', '1300', 3, '2019-04-03 10:05:02', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (202, 0, 'sensitive_word', NULL, '敏感字', 111, '2019-04-04 12:05:21', NULL, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (203, 202, 'sensitive_word', '1', '性感', 1, '2019-04-04 12:49:25', 1, '2019-04-05 19:28:04', 1, 1);
INSERT INTO `t_dictionary` VALUES (204, 202, 'sensitive_word', '2', '恐怖', 2, '2019-04-04 12:49:47', 1, '2019-04-04 17:34:49', 1, 1);
INSERT INTO `t_dictionary` VALUES (205, 202, 'sensitive_word', '3', '色情', 3, '2019-04-04 17:31:46', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (206, 202, 'sensitive_word', '', '恐怖', 2, '2019-04-04 17:35:07', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (209, 202, 'sensitive_word', '1', '性感', 1, '2019-04-05 16:35:59', 1, NULL, NULL, 0);
INSERT INTO `t_dictionary` VALUES (210, 71, 'frontDevice_model', '', 'IP话筒', 5, '2019-05-17 12:35:19', 1, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_manufacturer
-- ----------------------------
DROP TABLE IF EXISTS `t_manufacturer`;
CREATE TABLE `t_manufacturer`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_manufacturer_no` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '厂商编号',
  `f_manufacturer_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '厂商名称',
  `f_manufacturer_address` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '厂商地址',
  `f_linkman` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `f_tel` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) UNSIGNED NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '厂商' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_modulation
-- ----------------------------
DROP TABLE IF EXISTS `t_modulation`;
CREATE TABLE `t_modulation`  (
  `f_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_service_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '详情频道节目号',
  `f_pcr_pid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'pcr_pid',
  `f_dtmb_centre_frequency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dtmb频率',
  `f_dtmb_FEC` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dtmb前向纠错码',
  `f_dtmb_modulation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dtmb调制方式',
  `f_dtmb_Number_of_subcarrier` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dtmb子载波数量',
  `f_dtmb_frame_header_mode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dtmb帧头模式',
  `f_dtmb_interleaving_mode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dtmb交织模式',
  `f_dtmb_other_frequency_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dtmb其他频率标志',
  `f_dtmb_sfn_mfn_flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dtmb单频网多频网标志，默认值为0',
  `f_dvbc_frequency` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dvb-c频率',
  `f_dvbc_FEC_outer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dvb-c 前向纠错外码，值为0',
  `f_dvbc_FEC_inner` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dvb-c 前向纠错内码，值为0',
  `f_dvbc_modulation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dvb-c调制方式',
  `f_dvbc_symbol_rate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dvb-c 符号率',
  `f_dtmb_modulation_parameter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dtmb调制参数',
  `f_dvbc_modulation_parameter` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'dvb-c 符号率',
  `f_sort` tinyint(4) NULL DEFAULT NULL COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `t_operation_log`;
CREATE TABLE `t_operation_log`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `f_userid` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '用户id',
  `f_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `f_operation_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `f_operation_type` tinyint(3) UNSIGNED NULL DEFAULT NULL COMMENT '操作类型',
  `f_operation_content` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作内容',
  `f_operation_result` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作结果',
  `f_ip` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'Ip',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '操作日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_operation_log
-- ----------------------------
INSERT INTO `t_operation_log` VALUES (1, 1, '管理员', '2019-06-24 10:19:49', 3, '修改系统配置', '改变1条配置', '0:0:0:0:0:0:0:1');
INSERT INTO `t_operation_log` VALUES (2, 1, '管理员', '2019-06-24 10:19:52', 3, '修改系统配置', '改变1条配置', '0:0:0:0:0:0:0:1');

-- ----------------------------
-- Table structure for t_resource
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_resource_classification` tinyint(4) NULL DEFAULT NULL COMMENT '资源分类',
  `f_resource_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源名称',
  `f_parent_resource` int(10) UNSIGNED NULL DEFAULT NULL COMMENT '父资源',
  `f_resource_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源路径',
  `f_permission_code` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限代码',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  `f_resource_ico` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源图标',
  PRIMARY KEY (`f_id`) USING BTREE,
  UNIQUE INDEX `uk_resource_name`(`f_resource_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资源表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES (1, NULL, '制作播发', 0, 'broadcast/emergency', NULL, 0, '2018-12-11 20:38:44', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (2, NULL, '播发审核', 0, 'shenhe/shenheHandle', NULL, 1, '2018-12-11 20:39:27', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (3, NULL, '监测监控', 0, 'monitor/terminalStatus', NULL, 2, '2018-12-11 20:40:50', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (4, NULL, '效果评估', 0, 'effectEvaluate/statisticalTable', NULL, 3, '2018-12-11 20:40:50', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (5, NULL, '资源管理', 0, 'resourceManage/region', NULL, 4, '2018-12-11 20:40:50', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (6, NULL, '系统管理', 0, 'systemManage/systemConfigure', '', 5, '2018-12-11 20:40:50', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (7, NULL, '应急广播', 1, 'broadcast/emergency', '', 1, '2018-12-11 20:47:18', NULL, NULL, NULL, 0, 'img/leftmenu_1_1.svg');
INSERT INTO `t_resource` VALUES (8, NULL, '日常广播', 1, 'broadcast/daily', '', 2, '2018-12-11 20:47:18', NULL, NULL, NULL, 0, 'img/leftmenu_1_2.svg');
INSERT INTO `t_resource` VALUES (9, NULL, '监控系统', 3, '#', '', 6, '2018-12-11 20:50:55', NULL, NULL, NULL, 0, 'img/leftmenu_3_6.svg');
INSERT INTO `t_resource` VALUES (10, NULL, '视频监控', 9, 'monitor/vidioMonitor', '', 1, '2018-12-11 20:52:09', NULL, NULL, NULL, 1, '');
INSERT INTO `t_resource` VALUES (11, NULL, '地图监控', 9, 'monitor/mapMonitor', '', 2, '2018-12-11 20:52:09', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (12, NULL, '系统配置', 6, 'systemManage/systemConfigure', NULL, 1, '2018-12-15 16:21:51', NULL, NULL, NULL, 0, 'img/leftmenu_6_1.svg');
INSERT INTO `t_resource` VALUES (13, NULL, '广播演练', 1, 'broadcast/drill', NULL, 3, '2018-12-16 09:23:22', NULL, NULL, NULL, 0, 'img/leftmenu_1_3.svg');
INSERT INTO `t_resource` VALUES (14, NULL, '地图广播', 1, 'broadcast/map', NULL, 4, '2018-12-16 09:23:22', NULL, NULL, NULL, 0, 'img/leftmenu_1_4.svg');
INSERT INTO `t_resource` VALUES (15, NULL, '定时广播', 1, 'broadcast/schedule', NULL, 5, '2018-12-16 09:23:22', NULL, NULL, NULL, 0, 'img/leftmenu_1_5.svg');
INSERT INTO `t_resource` VALUES (16, NULL, '广播预案', 1, 'broadcast/advance', NULL, 5, '2018-12-16 09:23:22', NULL, NULL, NULL, 0, 'img/leftmenu_1_5.svg');
INSERT INTO `t_resource` VALUES (17, NULL, '音频管理', 1, 'broadcast/audioManage', NULL, 7, '2018-12-16 09:23:22', NULL, NULL, NULL, 0, 'img/leftmenu_1_7.svg');
INSERT INTO `t_resource` VALUES (18, NULL, '节目制作', 1, 'broadcast/programProduce', NULL, 8, '2018-12-16 09:23:22', NULL, NULL, NULL, 0, 'img/leftmenu_1_8.svg');
INSERT INTO `t_resource` VALUES (19, NULL, '图文发布', 1, 'broadcast/graphicRelease', NULL, 9, '2018-12-16 09:23:22', NULL, NULL, NULL, 1, 'img/leftmenu_1_9.svg');
INSERT INTO `t_resource` VALUES (20, NULL, '审核处理', 2, 'shenhe/shenheHandle', NULL, 1, '2018-12-16 10:48:34', NULL, NULL, NULL, 0, 'img/leftmenu_2_1.svg');
INSERT INTO `t_resource` VALUES (21, NULL, '审核日志', 2, 'shenhe/shenheLog', NULL, 2, '2018-12-16 10:48:34', NULL, NULL, NULL, 0, 'img/leftmenu_2_2.svg');
INSERT INTO `t_resource` VALUES (22, NULL, '终端播放状态', 3, 'monitor/terminalStatus', NULL, 1, '2018-12-16 10:54:21', NULL, NULL, NULL, 0, 'img/leftmenu_3_1.svg');
INSERT INTO `t_resource` VALUES (23, NULL, '终端回传参数', 3, 'monitor/terminalParam', NULL, 2, '2018-12-16 10:54:22', NULL, NULL, NULL, 0, 'img/leftmenu_3_2.svg');
INSERT INTO `t_resource` VALUES (24, NULL, '终端回传录音', 3, 'monitor/terminalSound', NULL, 3, '2018-12-16 10:54:22', NULL, NULL, NULL, 0, 'img/leftmenu_3_3.svg');
INSERT INTO `t_resource` VALUES (25, NULL, '异常设备记录', 3, 'monitor/exceptionDevice', NULL, 4, '2018-12-16 10:54:22', NULL, NULL, NULL, 0, 'img/leftmenu_3_4.svg');
INSERT INTO `t_resource` VALUES (26, NULL, 'GIS地图回传', 3, 'monitor/GISMapReturn', NULL, 5, '2018-12-16 10:54:22', NULL, NULL, NULL, 0, 'img/leftmenu_3_5.svg');
INSERT INTO `t_resource` VALUES (27, NULL, '统计报表', 4, 'effectEvaluate/statisticalTable', NULL, 0, '2018-12-16 10:55:18', NULL, NULL, NULL, 0, 'img/leftmenu_4_1.svg');
INSERT INTO `t_resource` VALUES (32, NULL, '区域管理', 5, 'resourceManage/region', NULL, 1, '2018-12-16 10:59:57', NULL, NULL, NULL, 0, 'img/leftmenu_5_1.svg');
INSERT INTO `t_resource` VALUES (33, NULL, '应急设备', 5, 'resourceManage/emergencyDevice', NULL, 2, '2018-12-16 10:59:57', NULL, NULL, NULL, 0, 'img/leftmenu_5_2.svg');
INSERT INTO `t_resource` VALUES (34, NULL, '监控设备', 5, 'resourceManage/monitorDevice', NULL, 3, '2018-12-16 10:59:57', NULL, NULL, NULL, 0, 'img/leftmenu_5_3.svg');
INSERT INTO `t_resource` VALUES (35, NULL, '电话名单', 5, 'resourceManage/telephoneList', NULL, 4, '2018-12-16 10:59:57', NULL, NULL, NULL, 0, 'img/leftmenu_5_4.svg');
INSERT INTO `t_resource` VALUES (36, NULL, '证书管理', 5, '#', NULL, 5, '2018-12-16 10:59:57', NULL, NULL, NULL, 0, 'img/leftmenu_5_5.svg');
INSERT INTO `t_resource` VALUES (37, NULL, '调度预案', 5, 'resourceManage/dispatchPlan', NULL, 6, '2018-12-16 10:59:57', NULL, NULL, NULL, 0, 'img/leftmenu_5_6.svg');
INSERT INTO `t_resource` VALUES (38, NULL, '设备管理', 5, '#', NULL, 7, '2018-12-16 10:59:57', NULL, NULL, NULL, 0, 'img/leftmenu_5_7.svg');
INSERT INTO `t_resource` VALUES (39, NULL, '领用证书', 36, 'resourceManage/receiveCertificate', NULL, 1, '2018-12-16 11:01:20', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (40, NULL, '发放证书', 36, 'resourceManage/distributeCertificate', NULL, 2, '2018-12-16 11:01:20', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (41, NULL, '升级文件管理', 38, 'resourceManage/updateFile', NULL, 1, '2018-12-16 11:02:06', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (42, NULL, '设备参数配置', 38, 'resourceManage/handUpdate', NULL, 3, '2018-12-16 11:02:06', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (43, NULL, '基础数据', 6, 'systemManage/baseData', NULL, 2, '2018-12-16 11:15:16', NULL, NULL, NULL, 0, 'img/leftmenu_6_2.svg');
INSERT INTO `t_resource` VALUES (44, NULL, '角色管理', 6, 'systemManage/role', NULL, 3, '2018-12-16 11:15:16', NULL, NULL, NULL, 0, 'img/leftmenu_6_3.svg');
INSERT INTO `t_resource` VALUES (45, NULL, '账号管理', 6, 'systemManage/user', NULL, 4, '2018-12-16 11:15:17', NULL, NULL, NULL, 0, 'img/leftmenu_6_4.svg');
INSERT INTO `t_resource` VALUES (46, NULL, '日志管理', 6, 'systemManage/log', NULL, 5, '2018-12-16 11:15:17', NULL, NULL, NULL, 0, 'img/leftmenu_6_5.svg');
INSERT INTO `t_resource` VALUES (47, NULL, '系统状态', 6, '#', NULL, 6, '2018-12-16 11:15:17', NULL, NULL, NULL, 0, 'img/leftmenu_6_6.svg');
INSERT INTO `t_resource` VALUES (48, NULL, '数据管理', 6, 'systemManage/database', NULL, 7, '2018-12-16 11:15:17', NULL, NULL, NULL, 0, 'img/leftmenu_6_7.svg');
INSERT INTO `t_resource` VALUES (49, NULL, '区域特色', 6, 'systemManage/regionFeature', NULL, 8, '2018-12-16 11:15:17', NULL, NULL, NULL, 1, 'img/leftmenu_6_8.svg');
INSERT INTO `t_resource` VALUES (50, NULL, '短信告警', 6, 'systemManage/SMSWarning', NULL, 9, '2018-12-16 11:15:17', NULL, NULL, NULL, 0, 'img/leftmenu_6_9.svg');
INSERT INTO `t_resource` VALUES (51, NULL, '系统升级', 6, 'systemManage/systemUpdate', NULL, 10, '2018-12-16 11:15:17', NULL, NULL, NULL, 0, 'img/leftmenu_6_10.svg');
INSERT INTO `t_resource` VALUES (52, NULL, '服务器状态', 47, 'systemManage/serverState', NULL, 1, '2018-12-16 11:17:48', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (53, NULL, '系统告警记录', 47, 'systemManage/systemWarning', NULL, 2, '2018-12-16 11:17:48', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (54, NULL, '数据备份', 48, 'systemManage/dataBackup', NULL, 1, '2018-12-16 11:17:48', NULL, NULL, NULL, 1, NULL);
INSERT INTO `t_resource` VALUES (55, NULL, '数据恢复', 48, 'systemManage/dataRecovery', NULL, 2, '2018-12-16 11:17:48', NULL, NULL, NULL, 1, NULL);
INSERT INTO `t_resource` VALUES (56, NULL, 'ts设备升级', 38, 'resourceManage/tsDeviceUpdate', NULL, 2, '2019-04-01 08:50:17', NULL, NULL, NULL, 0, NULL);
INSERT INTO `t_resource` VALUES (57, NULL, '设备广播', 1, 'broadcast/deviceBroadcast', NULL, 7, '2019-04-05 15:01:27', NULL, NULL, NULL, 0, 'img/leftmenu_5_2.svg');

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `f_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_role_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '角色名称',
  `f_role_description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 47 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '管理员', '管理员', 0, '2018-12-11 21:52:38', NULL, '2019-04-05 15:16:26', 1, 0);
INSERT INTO `t_role` VALUES (24, '制作人', '制作播放', 2, '2019-01-27 17:03:04', 8, '2019-02-25 21:38:19', 1, 0);
INSERT INTO `t_role` VALUES (25, '审核管理者', '审核管理', 3, '2019-01-27 17:29:21', 1, '2019-02-25 21:38:24', 1, 0);
INSERT INTO `t_role` VALUES (26, '告警对象', '系统、设备故障短信告警', 1, '2019-02-15 20:22:03', 1, '2019-02-15 20:22:21', 1, 0);
INSERT INTO `t_role` VALUES (39, '幸福村村长', '村长', 5, '2019-02-27 21:06:32', 1, NULL, NULL, 0);
INSERT INTO `t_role` VALUES (44, '六京村快递员', '11', 6, '2019-04-06 17:39:28', 1, NULL, NULL, 0);
INSERT INTO `t_role` VALUES (45, 'APP用户', '手机APP访问', 7, '2019-04-09 09:29:33', 1, '2019-04-12 16:01:27', 1, 0);
INSERT INTO `t_role` VALUES (46, '耿黄镇政府', '耿黄镇政府', 8, '2019-04-23 11:17:16', 1, NULL, NULL, 0);

-- ----------------------------
-- Table structure for t_role_and_resource_link
-- ----------------------------
DROP TABLE IF EXISTS `t_role_and_resource_link`;
CREATE TABLE `t_role_and_resource_link`  (
  `f_role_resources_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_role_id` int(11) UNSIGNED NOT NULL COMMENT '角色id',
  `f_resources_id` int(11) UNSIGNED NOT NULL COMMENT '资源id',
  PRIMARY KEY (`f_role_resources_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1204 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与资源相关表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role_and_resource_link
-- ----------------------------
INSERT INTO `t_role_and_resource_link` VALUES (647, 26, 6);
INSERT INTO `t_role_and_resource_link` VALUES (648, 26, 50);
INSERT INTO `t_role_and_resource_link` VALUES (649, 24, 1);
INSERT INTO `t_role_and_resource_link` VALUES (650, 24, 7);
INSERT INTO `t_role_and_resource_link` VALUES (651, 24, 8);
INSERT INTO `t_role_and_resource_link` VALUES (652, 24, 13);
INSERT INTO `t_role_and_resource_link` VALUES (653, 24, 14);
INSERT INTO `t_role_and_resource_link` VALUES (654, 24, 15);
INSERT INTO `t_role_and_resource_link` VALUES (655, 24, 16);
INSERT INTO `t_role_and_resource_link` VALUES (656, 24, 17);
INSERT INTO `t_role_and_resource_link` VALUES (657, 24, 18);
INSERT INTO `t_role_and_resource_link` VALUES (658, 24, 19);
INSERT INTO `t_role_and_resource_link` VALUES (659, 25, 2);
INSERT INTO `t_role_and_resource_link` VALUES (660, 25, 20);
INSERT INTO `t_role_and_resource_link` VALUES (661, 25, 21);
INSERT INTO `t_role_and_resource_link` VALUES (662, 25, 3);
INSERT INTO `t_role_and_resource_link` VALUES (663, 25, 22);
INSERT INTO `t_role_and_resource_link` VALUES (664, 25, 23);
INSERT INTO `t_role_and_resource_link` VALUES (665, 25, 24);
INSERT INTO `t_role_and_resource_link` VALUES (666, 25, 25);
INSERT INTO `t_role_and_resource_link` VALUES (667, 25, 26);
INSERT INTO `t_role_and_resource_link` VALUES (668, 25, 9);
INSERT INTO `t_role_and_resource_link` VALUES (669, 25, 10);
INSERT INTO `t_role_and_resource_link` VALUES (670, 25, 11);
INSERT INTO `t_role_and_resource_link` VALUES (671, 25, 6);
INSERT INTO `t_role_and_resource_link` VALUES (672, 25, 12);
INSERT INTO `t_role_and_resource_link` VALUES (673, 25, 43);
INSERT INTO `t_role_and_resource_link` VALUES (674, 25, 44);
INSERT INTO `t_role_and_resource_link` VALUES (675, 25, 45);
INSERT INTO `t_role_and_resource_link` VALUES (676, 25, 46);
INSERT INTO `t_role_and_resource_link` VALUES (677, 25, 47);
INSERT INTO `t_role_and_resource_link` VALUES (678, 25, 52);
INSERT INTO `t_role_and_resource_link` VALUES (679, 25, 53);
INSERT INTO `t_role_and_resource_link` VALUES (680, 25, 48);
INSERT INTO `t_role_and_resource_link` VALUES (681, 25, 49);
INSERT INTO `t_role_and_resource_link` VALUES (682, 25, 50);
INSERT INTO `t_role_and_resource_link` VALUES (683, 25, 51);
INSERT INTO `t_role_and_resource_link` VALUES (925, 39, 1);
INSERT INTO `t_role_and_resource_link` VALUES (926, 39, 7);
INSERT INTO `t_role_and_resource_link` VALUES (927, 39, 8);
INSERT INTO `t_role_and_resource_link` VALUES (928, 39, 13);
INSERT INTO `t_role_and_resource_link` VALUES (929, 39, 14);
INSERT INTO `t_role_and_resource_link` VALUES (930, 39, 15);
INSERT INTO `t_role_and_resource_link` VALUES (931, 39, 16);
INSERT INTO `t_role_and_resource_link` VALUES (932, 39, 17);
INSERT INTO `t_role_and_resource_link` VALUES (933, 39, 18);
INSERT INTO `t_role_and_resource_link` VALUES (934, 39, 19);
INSERT INTO `t_role_and_resource_link` VALUES (935, 39, 2);
INSERT INTO `t_role_and_resource_link` VALUES (936, 39, 20);
INSERT INTO `t_role_and_resource_link` VALUES (937, 39, 21);
INSERT INTO `t_role_and_resource_link` VALUES (938, 39, 3);
INSERT INTO `t_role_and_resource_link` VALUES (939, 39, 22);
INSERT INTO `t_role_and_resource_link` VALUES (940, 39, 23);
INSERT INTO `t_role_and_resource_link` VALUES (941, 39, 24);
INSERT INTO `t_role_and_resource_link` VALUES (942, 39, 25);
INSERT INTO `t_role_and_resource_link` VALUES (943, 39, 26);
INSERT INTO `t_role_and_resource_link` VALUES (944, 39, 9);
INSERT INTO `t_role_and_resource_link` VALUES (945, 39, 10);
INSERT INTO `t_role_and_resource_link` VALUES (946, 39, 11);
INSERT INTO `t_role_and_resource_link` VALUES (947, 39, 4);
INSERT INTO `t_role_and_resource_link` VALUES (948, 39, 27);
INSERT INTO `t_role_and_resource_link` VALUES (949, 39, 5);
INSERT INTO `t_role_and_resource_link` VALUES (950, 39, 32);
INSERT INTO `t_role_and_resource_link` VALUES (951, 39, 33);
INSERT INTO `t_role_and_resource_link` VALUES (952, 39, 34);
INSERT INTO `t_role_and_resource_link` VALUES (953, 39, 35);
INSERT INTO `t_role_and_resource_link` VALUES (954, 39, 36);
INSERT INTO `t_role_and_resource_link` VALUES (955, 39, 39);
INSERT INTO `t_role_and_resource_link` VALUES (956, 39, 40);
INSERT INTO `t_role_and_resource_link` VALUES (957, 39, 37);
INSERT INTO `t_role_and_resource_link` VALUES (958, 39, 38);
INSERT INTO `t_role_and_resource_link` VALUES (959, 39, 41);
INSERT INTO `t_role_and_resource_link` VALUES (960, 39, 42);
INSERT INTO `t_role_and_resource_link` VALUES (961, 39, 6);
INSERT INTO `t_role_and_resource_link` VALUES (962, 39, 12);
INSERT INTO `t_role_and_resource_link` VALUES (963, 39, 43);
INSERT INTO `t_role_and_resource_link` VALUES (964, 39, 44);
INSERT INTO `t_role_and_resource_link` VALUES (965, 39, 45);
INSERT INTO `t_role_and_resource_link` VALUES (966, 39, 46);
INSERT INTO `t_role_and_resource_link` VALUES (967, 39, 47);
INSERT INTO `t_role_and_resource_link` VALUES (968, 39, 52);
INSERT INTO `t_role_and_resource_link` VALUES (969, 39, 53);
INSERT INTO `t_role_and_resource_link` VALUES (970, 39, 48);
INSERT INTO `t_role_and_resource_link` VALUES (971, 39, 49);
INSERT INTO `t_role_and_resource_link` VALUES (972, 39, 50);
INSERT INTO `t_role_and_resource_link` VALUES (973, 39, 51);
INSERT INTO `t_role_and_resource_link` VALUES (1056, 1, 1);
INSERT INTO `t_role_and_resource_link` VALUES (1057, 1, 7);
INSERT INTO `t_role_and_resource_link` VALUES (1058, 1, 8);
INSERT INTO `t_role_and_resource_link` VALUES (1059, 1, 13);
INSERT INTO `t_role_and_resource_link` VALUES (1060, 1, 14);
INSERT INTO `t_role_and_resource_link` VALUES (1061, 1, 15);
INSERT INTO `t_role_and_resource_link` VALUES (1062, 1, 16);
INSERT INTO `t_role_and_resource_link` VALUES (1063, 1, 17);
INSERT INTO `t_role_and_resource_link` VALUES (1064, 1, 18);
INSERT INTO `t_role_and_resource_link` VALUES (1065, 1, 19);
INSERT INTO `t_role_and_resource_link` VALUES (1066, 1, 57);
INSERT INTO `t_role_and_resource_link` VALUES (1067, 1, 2);
INSERT INTO `t_role_and_resource_link` VALUES (1068, 1, 20);
INSERT INTO `t_role_and_resource_link` VALUES (1069, 1, 21);
INSERT INTO `t_role_and_resource_link` VALUES (1070, 1, 3);
INSERT INTO `t_role_and_resource_link` VALUES (1071, 1, 22);
INSERT INTO `t_role_and_resource_link` VALUES (1072, 1, 23);
INSERT INTO `t_role_and_resource_link` VALUES (1073, 1, 24);
INSERT INTO `t_role_and_resource_link` VALUES (1074, 1, 25);
INSERT INTO `t_role_and_resource_link` VALUES (1075, 1, 26);
INSERT INTO `t_role_and_resource_link` VALUES (1076, 1, 9);
INSERT INTO `t_role_and_resource_link` VALUES (1077, 1, 10);
INSERT INTO `t_role_and_resource_link` VALUES (1078, 1, 11);
INSERT INTO `t_role_and_resource_link` VALUES (1079, 1, 4);
INSERT INTO `t_role_and_resource_link` VALUES (1080, 1, 27);
INSERT INTO `t_role_and_resource_link` VALUES (1081, 1, 5);
INSERT INTO `t_role_and_resource_link` VALUES (1082, 1, 32);
INSERT INTO `t_role_and_resource_link` VALUES (1083, 1, 33);
INSERT INTO `t_role_and_resource_link` VALUES (1084, 1, 34);
INSERT INTO `t_role_and_resource_link` VALUES (1085, 1, 35);
INSERT INTO `t_role_and_resource_link` VALUES (1086, 1, 36);
INSERT INTO `t_role_and_resource_link` VALUES (1087, 1, 39);
INSERT INTO `t_role_and_resource_link` VALUES (1088, 1, 40);
INSERT INTO `t_role_and_resource_link` VALUES (1089, 1, 37);
INSERT INTO `t_role_and_resource_link` VALUES (1090, 1, 38);
INSERT INTO `t_role_and_resource_link` VALUES (1091, 1, 41);
INSERT INTO `t_role_and_resource_link` VALUES (1092, 1, 56);
INSERT INTO `t_role_and_resource_link` VALUES (1093, 1, 42);
INSERT INTO `t_role_and_resource_link` VALUES (1094, 1, 6);
INSERT INTO `t_role_and_resource_link` VALUES (1095, 1, 12);
INSERT INTO `t_role_and_resource_link` VALUES (1096, 1, 43);
INSERT INTO `t_role_and_resource_link` VALUES (1097, 1, 44);
INSERT INTO `t_role_and_resource_link` VALUES (1098, 1, 45);
INSERT INTO `t_role_and_resource_link` VALUES (1099, 1, 46);
INSERT INTO `t_role_and_resource_link` VALUES (1100, 1, 47);
INSERT INTO `t_role_and_resource_link` VALUES (1101, 1, 52);
INSERT INTO `t_role_and_resource_link` VALUES (1102, 1, 53);
INSERT INTO `t_role_and_resource_link` VALUES (1103, 1, 48);
INSERT INTO `t_role_and_resource_link` VALUES (1104, 1, 49);
INSERT INTO `t_role_and_resource_link` VALUES (1105, 1, 50);
INSERT INTO `t_role_and_resource_link` VALUES (1106, 1, 51);
INSERT INTO `t_role_and_resource_link` VALUES (1130, 44, 1);
INSERT INTO `t_role_and_resource_link` VALUES (1131, 44, 7);
INSERT INTO `t_role_and_resource_link` VALUES (1132, 44, 8);
INSERT INTO `t_role_and_resource_link` VALUES (1133, 44, 13);
INSERT INTO `t_role_and_resource_link` VALUES (1134, 44, 14);
INSERT INTO `t_role_and_resource_link` VALUES (1135, 44, 16);
INSERT INTO `t_role_and_resource_link` VALUES (1136, 44, 15);
INSERT INTO `t_role_and_resource_link` VALUES (1137, 44, 57);
INSERT INTO `t_role_and_resource_link` VALUES (1138, 44, 17);
INSERT INTO `t_role_and_resource_link` VALUES (1139, 44, 18);
INSERT INTO `t_role_and_resource_link` VALUES (1140, 44, 19);
INSERT INTO `t_role_and_resource_link` VALUES (1141, 44, 2);
INSERT INTO `t_role_and_resource_link` VALUES (1142, 44, 20);
INSERT INTO `t_role_and_resource_link` VALUES (1143, 44, 21);
INSERT INTO `t_role_and_resource_link` VALUES (1148, 45, 1);
INSERT INTO `t_role_and_resource_link` VALUES (1149, 45, 7);
INSERT INTO `t_role_and_resource_link` VALUES (1150, 45, 3);
INSERT INTO `t_role_and_resource_link` VALUES (1151, 45, 23);
INSERT INTO `t_role_and_resource_link` VALUES (1152, 45, 25);
INSERT INTO `t_role_and_resource_link` VALUES (1153, 46, 1);
INSERT INTO `t_role_and_resource_link` VALUES (1154, 46, 7);
INSERT INTO `t_role_and_resource_link` VALUES (1155, 46, 8);
INSERT INTO `t_role_and_resource_link` VALUES (1156, 46, 13);
INSERT INTO `t_role_and_resource_link` VALUES (1157, 46, 14);
INSERT INTO `t_role_and_resource_link` VALUES (1158, 46, 16);
INSERT INTO `t_role_and_resource_link` VALUES (1159, 46, 15);
INSERT INTO `t_role_and_resource_link` VALUES (1160, 46, 57);
INSERT INTO `t_role_and_resource_link` VALUES (1161, 46, 17);
INSERT INTO `t_role_and_resource_link` VALUES (1162, 46, 18);
INSERT INTO `t_role_and_resource_link` VALUES (1163, 46, 19);
INSERT INTO `t_role_and_resource_link` VALUES (1164, 46, 2);
INSERT INTO `t_role_and_resource_link` VALUES (1165, 46, 20);
INSERT INTO `t_role_and_resource_link` VALUES (1166, 46, 21);
INSERT INTO `t_role_and_resource_link` VALUES (1167, 46, 3);
INSERT INTO `t_role_and_resource_link` VALUES (1168, 46, 22);
INSERT INTO `t_role_and_resource_link` VALUES (1169, 46, 23);
INSERT INTO `t_role_and_resource_link` VALUES (1170, 46, 24);
INSERT INTO `t_role_and_resource_link` VALUES (1171, 46, 25);
INSERT INTO `t_role_and_resource_link` VALUES (1172, 46, 26);
INSERT INTO `t_role_and_resource_link` VALUES (1173, 46, 9);
INSERT INTO `t_role_and_resource_link` VALUES (1174, 46, 10);
INSERT INTO `t_role_and_resource_link` VALUES (1175, 46, 11);
INSERT INTO `t_role_and_resource_link` VALUES (1176, 46, 4);
INSERT INTO `t_role_and_resource_link` VALUES (1177, 46, 27);
INSERT INTO `t_role_and_resource_link` VALUES (1178, 46, 5);
INSERT INTO `t_role_and_resource_link` VALUES (1179, 46, 32);
INSERT INTO `t_role_and_resource_link` VALUES (1180, 46, 33);
INSERT INTO `t_role_and_resource_link` VALUES (1181, 46, 34);
INSERT INTO `t_role_and_resource_link` VALUES (1182, 46, 35);
INSERT INTO `t_role_and_resource_link` VALUES (1183, 46, 36);
INSERT INTO `t_role_and_resource_link` VALUES (1184, 46, 39);
INSERT INTO `t_role_and_resource_link` VALUES (1185, 46, 40);
INSERT INTO `t_role_and_resource_link` VALUES (1186, 46, 37);
INSERT INTO `t_role_and_resource_link` VALUES (1187, 46, 38);
INSERT INTO `t_role_and_resource_link` VALUES (1188, 46, 41);
INSERT INTO `t_role_and_resource_link` VALUES (1189, 46, 56);
INSERT INTO `t_role_and_resource_link` VALUES (1190, 46, 42);
INSERT INTO `t_role_and_resource_link` VALUES (1191, 46, 6);
INSERT INTO `t_role_and_resource_link` VALUES (1192, 46, 12);
INSERT INTO `t_role_and_resource_link` VALUES (1193, 46, 43);
INSERT INTO `t_role_and_resource_link` VALUES (1194, 46, 44);
INSERT INTO `t_role_and_resource_link` VALUES (1195, 46, 45);
INSERT INTO `t_role_and_resource_link` VALUES (1196, 46, 46);
INSERT INTO `t_role_and_resource_link` VALUES (1197, 46, 47);
INSERT INTO `t_role_and_resource_link` VALUES (1198, 46, 52);
INSERT INTO `t_role_and_resource_link` VALUES (1199, 46, 53);
INSERT INTO `t_role_and_resource_link` VALUES (1200, 46, 48);
INSERT INTO `t_role_and_resource_link` VALUES (1201, 46, 49);
INSERT INTO `t_role_and_resource_link` VALUES (1202, 46, 50);
INSERT INTO `t_role_and_resource_link` VALUES (1203, 46, 51);

-- ----------------------------
-- Table structure for t_role_and_user_association
-- ----------------------------
DROP TABLE IF EXISTS `t_role_and_user_association`;
CREATE TABLE `t_role_and_user_association`  (
  `f_role_and_user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `f_role_id` int(10) UNSIGNED NOT NULL COMMENT '角色id',
  `f_user_id` int(10) UNSIGNED NOT NULL COMMENT '用户id',
  PRIMARY KEY (`f_role_and_user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 116 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色与用户相关表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_role_and_user_association
-- ----------------------------
INSERT INTO `t_role_and_user_association` VALUES (2, 1, 2);
INSERT INTO `t_role_and_user_association` VALUES (3, 1, 3);
INSERT INTO `t_role_and_user_association` VALUES (24, 25, 11);
INSERT INTO `t_role_and_user_association` VALUES (25, 18, 4);
INSERT INTO `t_role_and_user_association` VALUES (42, 12, 7);
INSERT INTO `t_role_and_user_association` VALUES (47, 1, 6);
INSERT INTO `t_role_and_user_association` VALUES (52, 24, 10);
INSERT INTO `t_role_and_user_association` VALUES (56, 1, 8);
INSERT INTO `t_role_and_user_association` VALUES (70, 1, 12);
INSERT INTO `t_role_and_user_association` VALUES (71, 1, 13);
INSERT INTO `t_role_and_user_association` VALUES (72, 1, 14);
INSERT INTO `t_role_and_user_association` VALUES (73, 1, 15);
INSERT INTO `t_role_and_user_association` VALUES (74, 1, 16);
INSERT INTO `t_role_and_user_association` VALUES (75, 1, 18);
INSERT INTO `t_role_and_user_association` VALUES (76, 1, 19);
INSERT INTO `t_role_and_user_association` VALUES (78, 1, 21);
INSERT INTO `t_role_and_user_association` VALUES (79, 26, 23);
INSERT INTO `t_role_and_user_association` VALUES (81, 1, 24);
INSERT INTO `t_role_and_user_association` VALUES (82, 1, 20);
INSERT INTO `t_role_and_user_association` VALUES (83, 1, 9);
INSERT INTO `t_role_and_user_association` VALUES (84, 25, 31);
INSERT INTO `t_role_and_user_association` VALUES (85, 26, 32);
INSERT INTO `t_role_and_user_association` VALUES (86, 1, 35);
INSERT INTO `t_role_and_user_association` VALUES (87, 26, 37);
INSERT INTO `t_role_and_user_association` VALUES (88, 1, 42);
INSERT INTO `t_role_and_user_association` VALUES (89, 1, 51);
INSERT INTO `t_role_and_user_association` VALUES (92, 26, 50);
INSERT INTO `t_role_and_user_association` VALUES (93, 24, 48);
INSERT INTO `t_role_and_user_association` VALUES (98, 39, 45);
INSERT INTO `t_role_and_user_association` VALUES (103, 44, 53);
INSERT INTO `t_role_and_user_association` VALUES (105, 39, 52);
INSERT INTO `t_role_and_user_association` VALUES (106, 45, 54);
INSERT INTO `t_role_and_user_association` VALUES (109, 24, 56);
INSERT INTO `t_role_and_user_association` VALUES (111, 39, 49);
INSERT INTO `t_role_and_user_association` VALUES (112, 1, 55);
INSERT INTO `t_role_and_user_association` VALUES (114, 1, 1);
INSERT INTO `t_role_and_user_association` VALUES (115, 46, 57);

-- ----------------------------
-- Table structure for t_system_configuration
-- ----------------------------
DROP TABLE IF EXISTS `t_system_configuration`;
CREATE TABLE `t_system_configuration`  (
  `f_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `f_big_classification` tinyint(4) UNSIGNED NOT NULL COMMENT '大分类',
  `f_configuration_type` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '配置类型',
  `f_configuration_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置名称',
  `f_configuration_value` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '配置值',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE,
  UNIQUE INDEX `uk_config_name`(`f_configuration_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '系统配置表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_system_configuration
-- ----------------------------
INSERT INTO `t_system_configuration` VALUES (1, 3, '系统名称', 'web_title', '县级应急广播平台', 0, '2018-12-12 22:33:04', 1, '2019-05-17 12:33:53', 1, 0);
INSERT INTO `t_system_configuration` VALUES (2, 1, '省级服务器地址', 'province_server_url', '127.0.0.1', 1, '2018-12-15 17:53:22', NULL, '2019-03-26 19:47:54', 1, 0);
INSERT INTO `t_system_configuration` VALUES (3, 1, '省级服务器端口', 'province_server_port', '8888', 2, '2018-12-15 17:53:22', NULL, '2019-03-26 19:47:54', 1, 0);
INSERT INTO `t_system_configuration` VALUES (4, 1, '通讯超时时间(s)', 'province_server_timeout', '5', 3, '2018-12-15 17:53:22', NULL, '2019-03-26 19:47:54', 1, 0);
INSERT INTO `t_system_configuration` VALUES (7, 2, '服务器地址', 'transmit_server_url', '127.0.0.1', 1, '2018-12-15 17:58:11', NULL, '2019-05-19 15:34:00', 1, 0);
INSERT INTO `t_system_configuration` VALUES (8, 2, '服务器端口', 'transmit_server_port', '9000', 2, '2018-12-15 17:58:11', NULL, '2019-05-19 15:34:00', 1, 0);
INSERT INTO `t_system_configuration` VALUES (9, 2, '通讯超时时间(s)', 'transmit_server_timeout', '', 3, '2018-12-15 17:58:11', NULL, '2019-01-29 14:33:35', 1, 0);
INSERT INTO `t_system_configuration` VALUES (10, 4, '区县名称', 'county_name', '隆林各族自治县', 0, '2018-12-22 12:10:47', NULL, '2019-01-19 16:13:20', 1, 0);
INSERT INTO `t_system_configuration` VALUES (11, 5, '高德WebApiKey', 'amap_web_key', '3cce0d53462c75108aaed95f3d4dd103	', 0, '2018-12-22 12:11:30', NULL, NULL, NULL, 0);
INSERT INTO `t_system_configuration` VALUES (12, 5, '高德JsApiKey', 'amap_js_key', '0fa0d23d0d3e8738b0613a3112be10a7', 0, '2018-12-22 12:11:59', NULL, NULL, NULL, 0);
INSERT INTO `t_system_configuration` VALUES (14, 5, '自动备份开关', 'backup_auto', '0', 0, '2019-01-15 20:18:20', NULL, '2019-04-05 17:03:47', 1, 0);
INSERT INTO `t_system_configuration` VALUES (15, 5, '自动备份类型', 'backup_type', '1', 0, '2019-01-15 20:18:36', NULL, '2019-04-05 17:03:47', 1, 0);
INSERT INTO `t_system_configuration` VALUES (16, 5, '自动备份时间', 'backup_time', '17', 0, '2019-01-15 20:18:52', NULL, '2019-04-05 17:03:47', 1, 0);
INSERT INTO `t_system_configuration` VALUES (17, 3, '平台资源编码', 'platform_resource_code', '010141070400000001', 0, '2019-01-16 11:05:18', NULL, '2019-05-17 12:33:53', 1, 0);
INSERT INTO `t_system_configuration` VALUES (18, 3, '证书编号', 'certificate_number', '000000000001', 0, '2019-01-16 11:07:00', NULL, '2019-05-17 12:33:54', 1, 0);
INSERT INTO `t_system_configuration` VALUES (19, 3, '指令pid', 'instruction_pid', '20190119', 0, '2019-01-16 11:08:22', NULL, '2019-05-17 12:33:54', 1, 0);
INSERT INTO `t_system_configuration` VALUES (20, 6, 'CPU告警值(%)', 'alarm_cpu_value', '90', 0, '2019-01-22 20:44:01', NULL, NULL, NULL, 0);
INSERT INTO `t_system_configuration` VALUES (21, 6, '内存告警值(%)', 'alarm_memory_value', '90', 0, '2019-01-22 20:44:25', NULL, NULL, NULL, 0);
INSERT INTO `t_system_configuration` VALUES (22, 6, '磁盘告警值(%)', 'alarm_disk_value', '90', 0, '2019-01-22 20:44:58', NULL, NULL, NULL, 0);
INSERT INTO `t_system_configuration` VALUES (23, 2, 'DVB-C适配器Ip', 'dvbc_adapter_ip', '226.102.103.106', 0, '2019-01-29 09:46:09', NULL, '2019-05-19 15:34:00', 1, 0);
INSERT INTO `t_system_configuration` VALUES (24, 2, 'DVB-C适配器端口', 'dvbc_adapter_port', '8888', 0, '2019-01-29 09:46:36', NULL, '2019-05-19 15:34:00', 1, 0);
INSERT INTO `t_system_configuration` VALUES (25, 1, '音频服务器ip', 'audio_server_ip', '10.177.3.205', 0, '2019-01-29 14:08:07', NULL, '2019-05-19 15:34:00', 1, 0);
INSERT INTO `t_system_configuration` VALUES (26, 2, '音频服务器短端口', 'audio_server_port', '5000', 0, '2019-01-29 14:09:02', NULL, '2019-05-19 15:34:00', 1, 0);
INSERT INTO `t_system_configuration` VALUES (27, 1, '回传服务器ip', 'return_server_ip', '10.177.3.205', 0, '2019-01-29 14:10:16', NULL, '2019-05-19 15:34:00', 1, 0);
INSERT INTO `t_system_configuration` VALUES (28, 2, '回传服务器短端口', 'return_server_port', '7000', 0, '2019-01-29 14:09:02', NULL, '2019-05-19 15:34:00', 1, 0);
INSERT INTO `t_system_configuration` VALUES (29, 5, '高德离线地图url', 'amap_offline_url', 'http://wprd01.is.autonavi.com/appmaptile?x={x}&y={y}&z={z}&lang=zh_cn&size=1&scl=1&style=7', 0, '2019-01-31 20:02:59', NULL, NULL, NULL, 0);
INSERT INTO `t_system_configuration` VALUES (30, 5, '百度语音AppID', 'baidu_tts_appid', '15407923', 0, '2019-02-13 14:24:25', NULL, '2019-03-03 15:59:06', 1, 0);
INSERT INTO `t_system_configuration` VALUES (31, 5, '百度语音APIKey', 'baidu_tts_apikey', 'a67CuAbwyvzcshSB08KA7GO2', 0, '2019-02-13 14:26:34', NULL, '2019-03-03 15:59:06', 1, 0);
INSERT INTO `t_system_configuration` VALUES (32, 5, '百度语音SecretKey', 'baidu_tts_secretkey', 'mj1dkUweHyyo7g1FP2NAz9oVh0qNhahG', 0, '2019-02-13 14:27:00', NULL, '2019-03-03 15:59:06', 1, 0);
INSERT INTO `t_system_configuration` VALUES (37, 3, '平台私钥', 'private_key', '3945208F7B2144B13F36E38AC6D39F95889393692860B51A42FB81EF4DF7C5B8', 0, '2019-02-18 18:28:27', NULL, '2019-05-17 12:33:54', 1, 0);
INSERT INTO `t_system_configuration` VALUES (38, 3, '平台公钥', 'public_key', '09F9DF311E5421A150DD7D161E4BC5C672179FAD1833FC076BB08FF356F35020CCEA490CE26775A52DC6EA718CC1AA600AED05FBF35E084A6632F6072DA9AD13', 0, '2019-02-18 18:30:22', NULL, '2019-05-17 12:33:54', 1, 0);
INSERT INTO `t_system_configuration` VALUES (39, 5, '短信平台ip', 'sms_server_ip', '127.0.0.1', 0, '2019-02-18 19:41:42', NULL, '2019-02-18 19:55:24', 1, 0);
INSERT INTO `t_system_configuration` VALUES (40, 5, '短信平台port', 'sms_server_port', '9000', 0, '2019-02-18 19:42:05', NULL, '2019-02-18 19:55:24', 1, 0);
INSERT INTO `t_system_configuration` VALUES (41, 5, '短信平台用户名', 'sms_server_username', 'jtxd', 0, '2019-02-18 19:42:21', NULL, '2019-02-18 19:55:24', 1, 0);
INSERT INTO `t_system_configuration` VALUES (42, 5, '短信平台密码', 'sms_server_password', '89798486', 0, '2019-02-18 19:42:55', NULL, '2019-02-18 19:55:24', 1, 0);
INSERT INTO `t_system_configuration` VALUES (43, 5, '省级平台证书编号', 'province_ssl_num', '000000000000', 0, '2019-02-21 17:10:13', NULL, '2019-03-26 19:47:54', 1, 0);
INSERT INTO `t_system_configuration` VALUES (44, 5, '省级平台公钥', 'province_public_key', '09F9DF311E5421A150DD7D161E4BC5C672179FAD1833FC076BB08FF356F35020CCEA490CE26775A52DC6EA718CC1AA600AED05FBF35E084A6632F6072DA9AD13', 0, '2019-02-21 17:11:23', NULL, '2019-03-26 19:47:54', 1, 0);
INSERT INTO `t_system_configuration` VALUES (45, 5, '地面波TS适配器IP地址', 'dtmb_adapter_ip', '10.10.50.56', 0, '2019-02-21 21:49:54', NULL, '2019-05-19 15:34:00', 1, 0);
INSERT INTO `t_system_configuration` VALUES (46, 5, '地面波TS适配器IP端口', 'dtmb_adapter_port', '8888', 0, '2019-02-21 21:50:15', NULL, '2019-05-19 15:34:00', 1, 0);
INSERT INTO `t_system_configuration` VALUES (47, 5, 'IP流组播IP地址', 'multicast_ip', '39.164.104.10', 0, '2019-02-21 21:51:36', NULL, '2019-05-19 15:34:01', 1, 0);
INSERT INTO `t_system_configuration` VALUES (48, 5, 'IP流组播端口', 'multicast_port', '8088', 0, '2019-02-21 21:52:20', NULL, '2019-05-19 15:34:01', 1, 0);
INSERT INTO `t_system_configuration` VALUES (49, 5, 'IP流单播端口', 'unicast_port', '8089', 0, '2019-02-21 21:53:22', NULL, '2019-05-19 15:34:01', 1, 0);
INSERT INTO `t_system_configuration` VALUES (50, 8, '县平台', 'platform_prefix', '0101', 0, '2019-03-09 20:36:50', NULL, '2019-05-17 12:36:10', 1, 0);
INSERT INTO `t_system_configuration` VALUES (51, 8, '适配器', 'adapter_prefix', '0612', 0, '2019-03-09 20:37:25', NULL, '2019-05-17 12:36:10', 1, 0);
INSERT INTO `t_system_configuration` VALUES (52, 8, '终端', 'terminal_prefix', '0612', 0, '2019-03-09 20:37:53', NULL, '2019-05-17 12:36:10', 1, 0);
INSERT INTO `t_system_configuration` VALUES (53, 5, 'IP话筒TS端口', 'ts_port', '5500', 0, '2019-03-20 17:10:56', NULL, '2019-05-19 15:34:01', 1, 0);
INSERT INTO `t_system_configuration` VALUES (54, 5, 'IP话筒pid', 'pid', '1000', 0, '2019-03-20 17:11:10', NULL, '2019-05-19 15:34:01', 1, 0);
INSERT INTO `t_system_configuration` VALUES (55, 9, '时区设置', 'timeZone_set', '0', 0, '2019-04-04 14:49:06', NULL, '2019-06-24 10:19:52', 1, 0);
INSERT INTO `t_system_configuration` VALUES (56, 5, 'IP音频协议', 'protocol_set', '0', 0, '2019-05-06 17:29:10', NULL, '2019-05-17 17:56:24', 1, 0);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `f_id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `f_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `f_username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `f_password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `f_respective_region` int(11) UNSIGNED NOT NULL COMMENT '所属区域',
  `f_subordinate_unit` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属单位',
  `f_duties` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '职务',
  `f_tel` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `f_is_audit_automatic` tinyint(1) NULL DEFAULT 0 COMMENT '审核是否自动',
  `f_is_linkman` tinyint(1) NULL DEFAULT 0 COMMENT '是否是联系人',
  `f_is_effective` tinyint(1) NOT NULL DEFAULT 1 COMMENT '是否有效',
  `f_sort` tinyint(4) NULL DEFAULT 0 COMMENT '排序',
  `f_create_time` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `f_creator_id` int(11) NULL DEFAULT NULL COMMENT '创建者id',
  `f_update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `f_operator_id` int(11) NULL DEFAULT NULL COMMENT '更新者id',
  `f_delete_flag` tinyint(1) NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`f_id`) USING BTREE,
  UNIQUE INDEX `uk_account`(`f_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', '管理员', '8279603faf7658fded36ce6a400df107', 129, '1', '1', '13868672915', 0, 1, 1, 0, '2018-12-10 22:08:16', NULL, '2019-04-17 14:00:12', 1, 0);
INSERT INTO `t_user` VALUES (45, 'xfccz', '手动阀', 'd4d72fe8a5e64322b6415ac9ccf6a655', 185, '手动阀', '', '12', 0, 1, 1, NULL, '2019-03-23 13:39:18', 1, '2019-03-24 03:21:58', 1, 0);
INSERT INTO `t_user` VALUES (46, '请问', '算法', 'fc9c1f3e5be17a1b98ad19c77f963213', 215, '', '', '12', 0, NULL, 1, NULL, '2019-03-23 13:39:37', 1, NULL, NULL, 0);
INSERT INTO `t_user` VALUES (47, '而', '手动阀', '076ab251bef61277bde93ee8ea779111', 236, '', '', '123', 0, NULL, 1, NULL, '2019-03-23 13:41:29', 1, NULL, NULL, 0);
INSERT INTO `t_user` VALUES (48, 'zzr', 'df', '2d7d68b7a9b14552f49eefddc1c1f3a5', 236, '', '', '123', 0, NULL, 1, NULL, '2019-03-23 14:40:32', 1, '2019-03-24 03:16:15', 1, 0);
INSERT INTO `t_user` VALUES (49, 'shglz', 'd', '26e484bac6cb5eb3ef6c585c719eb742', 237, '1', '1', '1111', 0, NULL, 1, NULL, '2019-03-23 14:41:33', 1, '2019-04-13 09:25:48', 1, 0);
INSERT INTO `t_user` VALUES (50, 'gj', 'gj', 'c7ad420491c156e8c3197dbae8f4360f', 215, '', '', 'sdf', 0, NULL, 1, 0, '2019-03-23 15:41:40', 1, '2019-03-24 03:13:39', 1, 0);
INSERT INTO `t_user` VALUES (51, 'xiaozhao', '小王', '1c8471d99e07946860ed446340911d04', 130, '武汉纺织大学', '教师', '13886190934', 1, NULL, 1, 1, '2019-03-24 02:35:31', 1, NULL, NULL, 0);
INSERT INTO `t_user` VALUES (52, 'ljc', 'ljcry', 'bb88b09770286114c9aa0d5e254d16fe', 160, '1', '播发员', '13868672915', 0, NULL, 1, 1, '2019-04-05 11:59:53', 1, '2019-04-07 17:03:10', 1, 0);
INSERT INTO `t_user` VALUES (53, 'rgy1111', 'rgy1111', '506b7ed8950479aa4f41a127e370ed86', 160, '1', '1', '1', 0, NULL, 1, 1, '2019-04-06 17:40:02', 1, NULL, NULL, 0);
INSERT INTO `t_user` VALUES (54, 'appuser', '手机用户', 'e30986247a1b6f285f92d300722710d1', 129, '', '', '13968034069', 1, NULL, 1, 9, '2019-04-09 09:30:58', 1, NULL, NULL, 0);
INSERT INTO `t_user` VALUES (55, 'ly', 'ly', '7ab1bfe5e54a03f21d7b8a97176c017c', 254, '', '', '18871941615', 0, NULL, 1, NULL, '2019-04-10 10:46:02', 1, '2019-04-13 15:15:09', 1, 0);
INSERT INTO `t_user` VALUES (56, 'rgy2222', 'rgy2222', '37c9835cc48e2615f7371bb52c225f31', 164, '11', '播发员', '1111', 0, NULL, 1, 1, '2019-04-10 11:48:31', 1, '2019-04-10 11:49:58', 1, 0);
INSERT INTO `t_user` VALUES (57, '002', '耿黄镇政府', 'b15322ed9c7995a9331bc2ee6450429d', 164, '123', '11', '123', 0, NULL, 1, 1, '2019-04-23 11:19:01', 1, NULL, NULL, 0);

-- ----------------------------
-- Function structure for getSubRegion
-- ----------------------------
DROP FUNCTION IF EXISTS `getSubRegion`;
delimiter ;;
CREATE FUNCTION `getSubRegion`(rootId INT)
 RETURNS varchar(1024) CHARSET utf8
BEGIN DECLARE str VARCHAR(1024) ; DECLARE childId VARCHAR(1024) ; SET str = ''; SET childId =CAST(rootId AS CHAR); WHILE childId IS NOT NULL DO IF str = '' THEN SET str= childId; ELSE SET str= CONCAT(str,',',childId); END IF; SELECT GROUP_CONCAT(f_id) INTO childId FROM t_administrative_division WHERE FIND_IN_SET(f_parent_node,childId)>0 AND f_delete_flag = 0; END WHILE; RETURN str; END
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
