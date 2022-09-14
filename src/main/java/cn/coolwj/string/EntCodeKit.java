package cn.coolwj.string;
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

import com.alibaba.fastjson2.JSON;
import com.google.common.base.Splitter;

import java.util.List;

/**
 * @author Nigel Lee
 * @date 2022/9/13
 */
public class EntCodeKit {

    public static void main(String[] args) {
        List<String> list = Splitter.on("\n").trimResults().omitEmptyStrings().splitToList(input);
        String result = JSON.toJSONString(list);
        System.out.println("idea http client param ");
        System.out.println(result);
        System.out.println();
        System.out.println("sql param ");
        System.out.println("('" + String.join("','", list) + "')");
    }

    private final static String input = """
            12_14
            2201-v21
            2201_v21_2
            35870
            91130104MA0CLUCR1N
            91320102686735828H
            91340100791853973A
            9151000063313683XM
            A818
            AHJYJS
            AHSF999
            ahsxjs
            aquarius1910copy
            atgchj
            BDJS
            bj123
            bjbaohua
            BJGJ8888
            bjhyd202110
            BJHYJS
            bjhzxd
            bjjt66
            BJJX
            bjkysd
            bjrnkj
            bjxbhy
            BJZJMT
            bjzxzl
            bjzzwy
            brj888
            CAJD_2019
            cbjs
            CC888
            cd666888
            CDDZJT
            CHONGQINGYEANKEJI
            CKGS888
            CMDN
            CQBENXIJIANZHU
            cqgrs2021
            CQGS
            cqhh
            cqky2022
            cqltsj
            cqlxyl
            cqqs2021
            cqscz2022
            cqyc2022
            cqyxyl
            cqyyjz
            CTJD
            custsucess_project21
            CX888
            cxcm7477
            CYKJ8888
            DL888
            dongchuan888
            DR000
            dsjs
            DSYL123
            DZJY888
            FC1234567890
            FHDL2022
            FJSG_2018
            fmq123456
            GA000
            GD888888
            GDLX
            gdyfl888
            gdys002
            gdzy88
            gj123456
            GL_001
            GSJS_2019
            GXHTC
            GYJZ999
            gyqbdl
            gzbz888
            gzjy
            HBHGS
            HBLW
            hbnbhbgf
            hbxatj
            HBYX21
            hcgd007
            HDJG
            Hecom
            hh888
            hhzz
            hkgj202110
            HLJS
            HNDWJ
            HNHC2021
            hnhxsbd
            HNJHDL
            hnjy666
            HNWH_2022
            hnyn8888
            HNZP
            HNZT
            HR2022888
            hsxz888
            HTHD001
            HTJD999
            hy1234
            HY8888
            hzkn8888
            HZY_888
            infinity
            Ironhorse
            jcjsjt
            JCLW88
            JDST
            JD_8888
            JG_888
            JHJZ
            jiangsuxinlude
            jj123456
            JJTZS
            JL2019
            jngs
            JNJD888
            jr007
            jsdfjs
            JSHT
            JSJA
            JSJC
            JSLR666
            JSLT
            JSXHJS
            jsxshjs
            JUZS666
            JXJN
            JYJZZS8888
            KDJG666
            KJJZ_2012
            KY2004
            LBSY8888
            LCLN888
            LG_88888
            LH888888
            LHJZ123
            LJZS_2008
            LSGJ666
            lshg
            ltdc007
            lthj888
            LX888888
            lyjc
            LYSH
            lzkg8888
            lz_001
            mdjs888
            MNXT888
            MSHXZY
            MT888
            nbhdjs
            ND888888
            ntfyjs
            pinzhihs
            PJKC2022
            PZHGLLQ2021
            pzyt
            qcjs168
            QLJS888
            QLJZLW
            QMDL888
            QSY123
            QW_88888
            qxjz888888
            QYZS202107
            RH_888
            RJ888
            SANSHI888
            SCBYD
            SCJT888888
            SCJYJX2021
            SCRY_TEST
            SCSGSJS2020888
            SCYS
            SCZX001
            SDASZN666
            sddxjt
            sdhdsy
            sdjbjz
            SDJHJZ
            sdjzc666
            SDMXJZ
            shanghaiJM
            SHcengsheng
            SHGJ666
            SHLSJZ888
            SHPMKJ2022
            SHqhdk
            SHQSJS
            SHTQ
            SHXA8866
            SHYTZS
            SHZXZZ888
            SJ2013
            SRSY888
            ST888888
            SWWH
            sxhysbd666
            SXQCDL
            SXTCJT2021888
            SXTLJS
            SYYWGS
            SY_666
            SZ668866
            szbl6660
            SZJ888
            szjg88
            szjhw
            SZPS
            SZQAD
            szrcjs
            szsmjzjs
            szwls
            TCRT998
            tf666888
            tf888888
            Titan888
            TJJHB
            tjxyrhy
            TJ_88888
            tydl666
            TYJS
            TYYL
            TYYL888
            tzjzzs
            WH888
            WHHL
            wjzs
            WTJS001
            WY5668
            XCJS888
            XDAZ888
            xgm2020
            XH018
            xiao13750881038
            XJJS
            XK_888
            XN888888
            XRJ20211016
            XWJS
            YD0880
            YG8888
            ygxcl
            YGYL
            yhdqsjzgc
            yhjc666
            YRJS666
            YSJZ888
            YT666
            YTL188
            YTMW
            yx888888
            yxyl001
            YYJS6233
            YZJS
            YZXC
            ZA888
            ZB666666
            ZCJD888888
            ZDCY3100
            zdjs8888
            zhejiangTJ
            ZHSZ_8888
            ZHYL888
            ZHZX
            zjhc5858
            zjhh8888
            ZJJG2021
            ZJJS
            zjjz888
            zjnrjs
            zjyk1689
            ZJzg888
            zkdl168
            ZL888888
            zmdlq666
            zrjajt
            ZRJD666
            ZTJY
            ztjzgs
            ZY888888
            zycx
            ZYJS_2001
            ZYJT
            ZYJZ123
            ZYZC
            """;




}
