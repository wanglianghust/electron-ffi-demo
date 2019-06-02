//package com.tal.seg.paperpenclassroom;
//
//import java.util.*;
//
//public class SampleCode {
//    private static int index = 0;
//
//    public static final Map<String, List<OriginData>> macOriginData = new HashMap<String, List<OriginData>>();
//
//    public static void main(String[] args) {
//        RbtDeviceWifi rbtDeviceWifi = new RbtDeviceWifi();
//        rbtDeviceWifi.init(new RbtDataCallBack() {
//
//            @Override
//            public void onOriginData(String mac, int s, int x, int y, int p, byte[] buffer, int len) {
//                OriginData originData = new OriginData();
//                List<OriginData> list = new ArrayList<>();
//                index++;
//                originData.setbIndex(index);
//                originData.setbPenStatus(s);
//                originData.setbPress(p);
//                originData.setBx(x);
//                originData.setBy(y);
//                if (macOriginData.containsKey(mac)) {
//
//                    macOriginData.get(mac).add(originData);
//                } else {
//                    list.add(originData);
//                    macOriginData.put(mac, list);
//                }
//
//            }
//
//            @Override
//            public void onDeviceMac(String mac) {
//                System.out.println("onDeviceMac"+"mac=" + mac);
//            }
//
//            @Override
//            public void onDeviceName(String mac, String name) {
//                System.out.println("onDeviceName"+"mac=" + mac + " name=" + name);
//            }
//
//            @Override
//            public void onDeviceResult(String mac, int res, String name) {
//                System.out.println("mac=" + mac + " res" + res + " name=" + name);
//            }
//
//            @Override
//            public void onDeviceDisConnect(String mac) {
//                System.out.println("onDeviceDisConnect"+"mac=" + mac);
//            }
//
//            @Override
//            public void onDeviceKeyPress(String mac, int key) {
//                System.out.println("" +
//                        "onDeviceKeyPress "+"mac=" + mac + " key" + key);
//            }
//
//            @Override
//            public void onAnswerResult(String mac, int resId, byte[] result, int size) {
//                System.out.println("mac=" + mac + " resId=" + resId + " byte=" + result + " size=" + size);
//            }
//
//            @Override
//            public void onDeviceShowPage(String mac, int noteId, int pageId, int pageInfo) {
//                System.out.println("mac=" + mac + " noteId=" + noteId + " pageId=" + pageId + " pageInfo=" + pageInfo);
//            }
//
//            @Override
//            public void onErrorMsg(String mac, int cmd, String msg) {
//                System.out.println("mac=" + mac + " cmd=" + cmd + " msg=" + msg);
//            }
//
//            @Override
//            public void onCanvasInfo(String mac, int type, int canvasId) {
//                System.out.println("mac=" + mac + " type=" + type + " canvasId=" + canvasId);
//
//            }
//
//            @Override
//            public void onOptimizeData(String mac, short s, short x, short y, float width, float speed) {
//                System.out.println("mac=" + mac + " s=" + s + " x=" + x + " y=" + y + " width=" + width + " speed=" + speed);
//            }
//        });
//
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int iCmdCode = scanner.nextInt();
//            switch (iCmdCode) {
//
//                case 0: {
//                    // 开始服务
//                    System.out.println("开始服务 = " + rbtDeviceWifi.startServer());
//
//                }
//                break;
//
//                case 1: {
//                  rbtDeviceWifi.configNet();
//                }
//                break;
//                case 2: {
//                    // 开始手写答题
//                    rbtDeviceWifi.startAnswer(0, 0, "", "");
//                }
//                break;
//                case 3: {
//                    // 主观题
//                    rbtDeviceWifi.startAnswer(1, 3, "111", "");
//                }
//                break;
//                case 4: {
//                    rbtDeviceWifi.stopAnswer();
//                }
//                break;
//                case 5: {
//                    rbtDeviceWifi.endAnswer();
//                    for (String key : macOriginData.keySet()) {
//                        String value = macOriginData.get(key).toString();
//                        System.out.println(value);
//                    }
//                }
//                break;
//                case 6: {
//                    // 停止服务
//                    rbtDeviceWifi.stopServer();
//                }
//                break;
//                case 7: {
//                    //释放
//                    rbtDeviceWifi.unInit();
//                }
//                break;
//
//                case 8: {
//                    //设置学生名称
//                    rbtDeviceWifi.configStu("1B2A00000F28", "0006");
//                }
//                break;
//                case 9: {
//                    //设置学生名称
//                    rbtDeviceWifi.configStu("1B2A00000F28", "1", "00F028");
//                }
//                break;
//                case 10: {
//                    //设置报点频率
//                    rbtDeviceWifi.configFreq(5);
//                }
//                break;
//                case 11: {
//                    //设置休眠时间
//                    rbtDeviceWifi.configSleep(5);
//                }
//                break;
//                case 12: {
//                    //打开模组
//                    rbtDeviceWifi.openModule(true);
//                }
//                break;
//                case 13: {
//                    //获取画布
//                    rbtDeviceWifi.getCanvasId(0);
//                }
//                break;
//                case 14: {
//                    //设置打开悬浮点
//                    rbtDeviceWifi.openSuspension(true);
//                }
//                break;
//                case 15: {
//                    //设置刷新时间 1-5秒
//                    rbtDeviceWifi.setScreeFreq(5);
//                }
//                break;
//                case 16: {
//                    rbtDeviceWifi.configWifi("yangpeng", "yangpeng", "");
//                }
//                break;
//                case 17: {
//                    rbtDeviceWifi.configWifiNet("yangpeng", "yangpeng", "192.168.99.199", 6001, false, true, "");
//                }
//            }
//        }
//    }
//}
