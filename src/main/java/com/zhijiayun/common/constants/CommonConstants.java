package com.zhijiayun.common.constants;

/**
 * @author zhangyu
 * @description 常用变量
 * @date 2018/7/6 上午11:11
 */
public final class CommonConstants {

    public static final Long superPlatId = 1L;

    /**
     * 超级管理员角色
     */
    public static final Long superRole = 1L;

    /**
     * 账号默认密码(带改动)
     */
    public static final String initPassword = "000000";

    /**
     * 文件分隔符
     */
    public static final String FILE_SPLIT = "/";

    /**
     * 菜单类型
     */
    public enum MenuType {
        /**
         * 顶级菜单
         */
        TOPMENU(1),
        /**
         * 子菜单
         */
        MENU(2),
        /**
         * 按钮
         */
        BUTTON(3);

        private int value;

        MenuType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 客户类型
     */
    public enum CustomerType {
        /**
         * 新客户
         */
        NEW(0),
        /**
         * 高意向
         */
        HIGH_INTEN(1),
        /**
         * 有意向
         */
        HAVE_INTEN(2),
        /**
         * 观望中
         */
        WATCHING(3),
        /**
         * 无效
         */
        INVALID(4),
        /**
         * 订单客户
         */
        ORDER(5),
        /**
         * 已交付
         */
        PAID(6);

        private Integer value;

        CustomerType(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }

    /**
     * 账号状态
     */
    public interface OperStatus {
        int normal = 1;//正常
        int isDelete = 2;//已删除
        int expired = 3;//已失效
    }

    /**
     * 角色类型
     */
    public interface RoleType {
        int inital = 0;//默认
        int customize = 1;//自定义
    }

    /**
     * 默认角色名字
     */
    public interface DefultRoleName{
        String headquarter_senior_admin = "总部高级管理员";
        String division_senior_admin = "分部高级管理员";
        String merchant_leader = "门店高级管理员";
        String merchant_employ = "门店店员";

    }

    /**
     * 小程序类型
     */
    public interface AppletType{
        String gmeja_c = "gmejac";//集美家c端小程序
        String gmeja_b = "gmejab";//集美家b端小程序
    }

    /**
     * 是否默认客服
     */
    public interface IsDefaultCs {
        int no = 0;//不是
        int yes = 1;//是
    }

    /**
     * 是否默认处理人
     */
    public interface  IsDefaultHandler{
        int no =0;
        int yes=1;
    }

    /**
     * 短信是否发送成功
     */
    public interface IsSmsSuccess {
        int no = 0;//失败
        int yes = 1;//成功
    }

    /**
     * 二维码类型
     */
    public interface CodeType {
        int toC = 0;//扫码进入业主端
        int toB = 1;//扫码进入商家端
    }

    /**
     * 二维码类型
     */
    public interface ApplyStatus {
        int applying = 0;//申请中
        int agree = 1;//已同意
        int refuse = 2;//拒绝
    }

    /**
     * 查询时间范围
     */
    public interface rangeType {
        int today = 0;//今日
        int yesterday = 1;//昨日
        int lastweek = 2;//上周
        int thisMonth = 3;//本月
    }

    /**
     * 足迹类型,0进入店铺1点击电话2点击案例3点击分享动态4点击分享店铺
     */
    public interface footType {
        int enterMerchant = 0;//进入店铺
        int clickPhone = 1;//点击电话
        int clickDynamic = 2;//点击案例
        int clickShareDynamic = 3;//点击分享动态
        int clickShareMerchant = 4;//点击分享店铺
    }
}
