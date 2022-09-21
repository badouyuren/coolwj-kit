package cn.coolwj.cicd;
/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the god animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 */

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Nigel Lee
 * @date 2022/9/8
 */

@AllArgsConstructor
@Data
public class CicdJob {

    private Integer id;
    private String name;
    private String param = CicdConfig.CICD_COMMON_BUILD_PARAM;
    private String branchStart = "origin/";
    private boolean isShortName = false;
    private boolean isDeploy = false;
    private boolean isMutexWithZeroProject;
    private boolean isPrintUnderLine;
    private boolean isServer;


    public CicdJob(Integer id, String name, String param, String branchStart) {
        this.id = id;
        this.name = name;
        this.param = param;
        this.branchStart = branchStart;
    }

    public CicdJob(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CicdJob(Integer id, String name, boolean isMutexWithZeroProject) {
        this.id = id;
        this.name = name;
        this.isMutexWithZeroProject = isMutexWithZeroProject;
    }

    public CicdJob(Integer id, String name, boolean isShortName, boolean isDeploy, boolean isServer) {
        this.id = id;
        this.name = name;
        this.isShortName = isShortName;
        this.isDeploy = isDeploy;
        this.isServer = isServer;
    }
}