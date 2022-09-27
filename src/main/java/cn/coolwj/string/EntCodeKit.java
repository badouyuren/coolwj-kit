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
        List<String> list = Splitter.on("\n").trimResults().omitEmptyStrings().splitToList(input2);
        String result = JSON.toJSONString(list);
        System.out.println("idea http client param ");
        System.out.println(result);
        System.out.println();
        System.out.println("sql param ");
        System.out.println("('" + String.join("','", list) + "')");
    }

    private final static String input2 = """
            00006
            0001
            0002
            04819
            11_23
            133333
            156367
            19912
            2021hagc
            2021zyaz
            20466
            223001
            22_14
            22_56
            236725
            325608
            345676
            346256
            346721
            34711
            36334
            36903
            40379
            41364
            42804
            44_55
            51181
            80808088
            8090999
            88008800
            8888808
            888888
            91110105633707225A
            91110111339707072K
            91120116MA05JRGC91
            91130131MA0D0R4D4J
            91130200795485784T
            91130400MA07LXU92M
            911405000562529442
            91310000MA1FL4WNX3
            91320117MA1P6UDGX4
            913202001360006594
            91320205737826093M
            91320211591120441R
            91321102MA20P9896A
            914403003425972736
            914403005586552335
            91440300708491861D
            91440600351946201G
            91510105MA6AQWGU3W
            9564
            99999
            999998
            9999998
            absha
            AD18907181177
            AD2021
            af12345
            AHGC
            ahgd888
            AHHGJS
            ahhsj5155
            AHHY
            ahkxjz
            ahlsjs
            ahlw001
            AHSJ
            AHTSJS
            ahxykm
            AHZL888
            AJZS
            anshjs
            ANSTYT
            antn888
            asjz203
            ASM2020
            AT888888
            AYDJS
            bajs
            Banggroup
            baofeng
            BBBSL001
            bbghd888
            bdwh3031
            BDZS2021
            BEHJ
            bf888888
            bfdjgg
            bg01
            bgsw
            BHSH
            BJ888888
            bjbem
            bjbfsj
            bjbnr4456
            bjdth
            BJFN
            BJFSDDL
            BJGDJY
            bjgdyc
            BJGLJS
            BJH8888
            bjhbdb2022
            bjhdrt202112
            bjhtty
            bjhyky
            bjhyxy
            BJHZJZ
            bjjyx
            bjkwjd
            BJLHY
            BJLQFZ
            bjltxa
            BJMCZY
            bjmlm
            BJNSW
            BJQS
            BJRJTY
            BJSDLD
            BJSLHW123
            bjssrh
            bjsyyd
            bjtfdq
            BJTLJS
            bjtrsz
            bjwzx
            bjxxjs
            bjycyl2022
            bjyfzs
            bjyjgc
            bjylec
            BJYS8888
            bjzhsjyljh
            BJZKSZ
            bjztjg
            bjzxsd
            BJ_88888
            BKZD123
            BL123
            BLF3049
            BLSHJZ888
            BNSD
            BQZS123
            BS3850
            BSG2022
            BSHJZ
            BSJS
            BT888
            btjgjt
            BYDL001
            BZG999
            bzhydl
            bzyx1234
            c123456
            cadairCRM
            CBZN00001
            CD12345
            CDDL2020
            CDFH_TEST
            CDJJ888
            CDJXW_TEST
            CDLQ2021
            CDRYD
            CDSHYT2019888
            CDTT
            CDTY
            CDZX001
            ch666666
            CHCT
            chengbo
            chinasign
            CHJ001
            CHYJS888
            CKJZ999
            CKWL_001
            cljs
            CNCH6886
            cqar
            cqatjs
            cqbg
            CQBOYANJIANSHE
            cqca2020
            cqcj
            cqcjyl
            CQCTZS
            cqddyl
            cqdqjz
            cqdzsz
            cqfgkj
            cqhcblg
            cqhgjs
            cqhljs
            cqhnxf
            cqhuaan
            cqhy
            cqhyjd
            cqhz
            cqjc
            cqjh
            cqjhyl
            cqjk
            cqjl
            cqjy
            cqjy123
            cqjyj
            cqjysy888
            cqklhb
            cqlm
            cqmgdt
            cqmt
            cqnt
            CQNYZN
            cqpwjs
            cqqjgjg
            cqqr
            cqqrzm
            cqQZH2021615
            cqqzjs
            cqruizhou
            cqsc
            cqsc2020
            cqsf2020
            CQSJ
            cqsltkj
            CQSRA
            CQSRYHHYL
            cqstdc
            cqtianrui
            cqxfjc2020
            cqxh
            cqxqjd
            CQYB2019
            CQYHJS
            cqyp
            cqys
            CQyuanoudianzi
            cqyxlq
            cqyyjd
            cqyzdt
            CQYZKJ
            cqzdhl2022
            CQZL
            CS888
            CSBW-888
            CSDL888
            CSJG
            CSJS
            CSJZ_1997
            CSSW888
            CSSZ_8888
            CSTZTZ
            CSWY
            ct888888
            ctqjz
            CX111
            CX888888
            cxgk
            CXJS888
            czjtzs
            czsjtlq666
            dc2021
            DC888888
            DD888
            DDDB
            ddsobmy
            detong
            DFBJ888
            dfjzzs
            dfyq88688
            dghl
            DGTXJS
            DH888888
            DHCC99
            dhcj66
            dhjs123456
            dh_001
            DJ666
            DJSZ
            dkzxsxzd
            dmd123
            DMGC8888
            DMRS888
            DMSW
            dmzs1280
            DQJS_888
            DS2021
            DSZS
            DTSY20210126
            dw8888
            DX6185
            DX888888
            dy0524
            dygd
            DY_888
            DZSY
            dz_001
            epnk001
            ex12345
            fangzhoujianshe
            FB888888
            FB_888
            fc123456
            FD888
            FJGH888
            FJSSAJZGCYXGS888
            FKY666
            FS888
            FSSHYJD
            FSZH777
            FYSJ888
            fysz
            GCHJ
            GCSZ
            GC_888
            gdcy
            GDdd168
            GDHJH
            gdht88
            GDHXTX888
            gdjaxf
            GDJH888
            GDKX
            gdlk88
            gdll888
            GDXJ001
            gdyy88
            GEXY
            ghjy007
            GJT001
            GLTXNY
            GLZM021
            GRD8888
            GS888888
            GSLH001
            GSLH_2006
            gsxcl
            GSYL888
            GTRA2019
            gtssjj
            guangqujianzhu
            GWSY888
            GXGCDL
            GXGG_88
            GXHS
            GXJCKC
            GXLD
            GXTH
            gycj8888
            gyjd
            gyly6803
            gzds888
            GZJGJL
            GZJS021
            GZKD001
            gzmc
            gzt123
            gzyh
            GZYJ
            gzys
            GZYXD888
            GZZDX
            GZZL2021
            gzzs
            ha888888
            hanerjianzhu
            hangzhoubenxi
            HAS888
            HB1413
            hbbyjz001
            hbgb_2020
            hbgg8888
            HBGH
            hbhk
            HBHMJZ
            hbhrjcgc666
            HBHY123
            hbhz_1
            hbjc
            hbqfwjz
            hbsm
            HBTT
            HBXCL
            hbyc888
            hbytlqgcyxgs
            HC2001
            hc888
            hcgc666
            HCZX001
            HD000
            hddl666
            HDJNHB
            HDJS2022
            HDMQ
            HDRJ
            HDSHYJZ666
            hdt_2018
            hejg
            hengdongjianshe
            HF001
            HF666
            hfjs666
            hfzs888888
            HH2022
            HHJD
            HHJS666
            HHJZ888
            HHJZLW888
            HHSTHFDC666
            hj123456
            hjjc88
            HKD2021
            HL0665
            hl888888
            HLGQ666
            HLHB888
            HM2020
            HMCS
            HMHCJS888
            hncc888
            HNCSGC
            HNDX
            HNDYJC
            HNDZKTY
            hngc2351
            hngd666
            HNGJHY
            HNHP2019
            hnhtdl
            HNHTY
            HNHXJN
            HNJGJZ
            hnjl666
            HNJT888
            hnjtgc
            HNJTXCL
            hnjy2022
            HNKNT
            hnlh66
            HNLXJS
            HNQHJZ
            HNSZ5087
            """;

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
