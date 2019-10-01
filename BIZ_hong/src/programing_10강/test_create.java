package programing_10��;



import java.sql.*;

public class test_create {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver"); 
		Connection conn = DriverManager.getConnection
				("jdbc:mysql://192.168.56.102:3306/songdb","root","1234");						// DB �� ����
		Statement stmt = conn.createStatement();		// DB ��ɹ���? �غ�
	
		
		stmt.execute( "create table THTSKS010H00(" +
				"stnd_iscd varchar(13) not null" + 			/*  NOT_NULL ǥ�� �����ڵ�                      */
			    ", bsop_date int not null" +                  /*  NOT_NULL �ֽ� ���� ����                     */
			    ", shrn_iscd varchar(10) not null" +         /*  NOT_NULL �������� ���� �����ڵ�             */
			    ", stck_prpr int" +                         /*  �ֽ� ����                                   */
			    ", tck_oprc int"  +                        /*  �ֽ� �ð�                                   */
			    ", stck_hgpr int"  +                       /*  �ֽ� �ְ�                                 */
			    ", stck_lwpr int"  +                       /*  �ֽ� ������                                 */
			    ", prdy_vrss_sign varchar(5)"  +          /*  ���� ��� ��ȣ                              */
			    ", prdy_vrss int"   +                     /*  ���� ���                                   */
			    ", prdy_ctrt float"  +                      /*  ���� �����                                 */
			    ", prdy_vol bigint"  +                       /*  ���� �ŷ���                                 */
			    ", acml_vol bigint" +                        /*  ���� �ŷ���                                 */
			    ", acml_tr_pbmn bigint"  +                   /*  ���� �ŷ� ���                              */
			    ", askp1 int"   +                        /*  �ŵ�ȣ��1                                   */
			    ", bidp1 int"   +                         /*  �ż�ȣ��1                                   */
			    ", total_askp_rsqn bigint" +                   /*  �� �ŵ�ȣ�� �ܷ�                            */
			    ", total_bidp_rsqn bigint"+                    /*  �� �ż�ȣ�� �ܷ�                            */
			    ", seln_cntg_smtn bigint"  +                   /*  �ŵ� ü�� �հ�                              */
			    ", shnu_cntg_smtn bigint" +                   /*  �ż� ü�� �հ�                              */
			    ", seln_tr_pbmn bigint"  +                     /*  �ŵ� �ŷ� ���(����)                        */
			    ", shnu_tr_pbmn bigint"  +                    /*  �ż� �ŷ� ���(����)                        */
			    ", seln_cntg_csnu int" +                    /*  �ŵ� ü�� �Ǽ�                              */
			    ", shnu_cntg_csnu int"  +                   /*  �ż� ü�� �Ǽ�                              */
			    ", w52_hgpr int"    +                       /*  52���� �ְ�                               */
			    ", w52_lwpr int"    +                       /*  52���� ������                               */
			    ", w52_hgpr_date int" +                     /*  52���� �ְ� ����                          */
			    ", w52_lwpr_date int"   +                   /*  52���� ������ ����                          */
			    ", ovtm_untp_bsop_hour int" +               /*  �ð��� ���ϰ� ���� �ð�                     */
			    ", ovtm_untp_prpr int"   +                  /*  �ð��� ���ϰ� ���簡                        */
			    ", ovtm_untp_prdy_vrss int" +               /*  �ð��� ���ϰ� ���� ���                     */
			    ", ovtm_untp_prdy_vrss_sign varchar(5)" +   /*  �ð��� ���ϰ� ���� ��� ��ȣ                */
			    ", ovtm_untp_askp1 int"     +               /*  �ð��� ���ϰ� �ŵ�ȣ��1                     */
			    ", ovtm_untp_bidp1 int"  +                  /*  �ð��� ���ϰ� �ż�ȣ��1                     */
			    ", ovtm_untp_vol bigint"     +                 /*  �ð��� ���ϰ� �ŷ���                        */
			    ", ovtm_untp_tr_pbmn bigint" +                 /*  �ð��� ���ϰ� �ŷ� ���                     */
			    ", ovtm_untp_oprc int"    +                 /*  �ð��� ���ϰ� �ð�                          */
				", ovtm_untp_hgpr int"   +                  /*  �ð��� ���ϰ� �ְ�                        */
			    ", ovtm_untp_lwpr int"   +                  /*  �ð��� ���ϰ� ������                        */
			    ", mkob_otcp_vol bigint"    +                  /*  �尳���� �ð������� �ŷ���                  */
			    ", mkob_otcp_tr_pbmn bigint"   +               /*  �尳���� �ð������� �ŷ� ���               */
			    ", mkfa_otcp_vol bigint"       +               /*  �������� �ð������� �ŷ���                  */
			    ", mkfa_otcp_tr_pbmn bigint"    +              /*  �������� �ð������� �ŷ� ���               */
			    ", mrkt_div_cls_code varchar(5)" +            /*  ���� �з� ���� �ڵ�                         */
			    ", pstc_dvdn_amt bigint"    +                /*  �ִ� ��� �ݾ�                              */
			    ", lstn_stcn bigint"   +                       /*  ���� �ּ�                                   */
			    ", stck_sdpr int"   +                       /*  �ֽ� ���ذ�                                 */
			    ", stck_fcam float"     +                     /*  �ֽ� �׸鰡                                 */
			    ", wghn_avrg_stck_prc double"   +              /*  ���� ��� �ֽ� ����                         */
			    ", issu_limt_rate float"    +                 /*  ���� �ѵ� ����                              */
			    ", frgn_limt_qty bigint"     +                 /*  �ܱ��� �ѵ� ����                            */
			    ", oder_able_qty bigint"      +                /*  �ֹ� ���� ����                              */
			    ", frgn_limt_exhs_cls_code varchar(5)" +      /*  �ܱ��� �ѵ� ���� ���� �ڵ�                  */
			    ", frgn_hldn_qty bigint"         +             /*  �ܱ��� ���� ����                            */
			    ", frgn_hldn_rate float"   +                  /*  �ܱ��� ���� ����                            */
			    ", hts_frgn_ehrt float"   +                   /*  HTS �ܱ��� ������                           */
			    ", itmt_last_nav float"   +                   /*  ���� ���� NAV                               */
			    ", prdy_last_nav float"    +                  /*  ���� ���� NAV                               */
			    ", trc_errt float"      +                     /*  ���� ������                                 */
			    ", dprt float"       +                        /*  ������                                      */
			    ", ssts_cntg_qty bigint"  +                    /*  ���ŵ��������Ǹŵ�ü�����                  */
			    ", ssts_tr_pbmn bigint"    +              /*  ���ŵ��������Ǹŵ��ŷ����                  */
			    ", frgn_ntby_qty bigint"   +              /*  �ܱ��� ���ż�                               */
			    ", flng_cls_code varchar(5)"  +               /*  ������ �ڵ�                                 */
			    ", prtt_rate float"           +               /*  ���� ����                                   */
			    ", acml_prtt_rate float"   +                  /*  ���� ���� ����                              */
			    ", stdv float"         +                      /*  ��ü�����ܰ����                            */
			    ", beta_cfcn float"    +                      /*  ��Ÿ ���(90��)                             */
			    ", crlt_cfcn float"  +                        /*  DEL ��� ���                               */
			    ", bull_beta float"  +                        /*  DEL ���� ���                               */
			    ", bear_beta float"  +                        /*  DEL �༼ ���                               */
			    ", bull_dvtn float"   +                       /*  DEL ���� ����                               */
			    ", bear_dvtn float"  +                        /*  DEL �༼ ����                               */
			    ", bull_crlt float"  +                        /*  DEL ���� ������                           */
			    ", bear_crlt float"  +                        /*  DEL �༼ ������                           */
			    ", stck_mxpr int"  +                        /*  �ֽ� ���Ѱ�                                 */
			    ", stck_llam int"   +                       /*  �ֽ� ���Ѱ�                                 */
			    ", icic_cls_code varchar(5)"   +              /*  ���� ���� �ڵ�                              */
			    ", itmt_vol bigint"       +                    /*  ���� �ŷ���                                 */
			    ", itmt_tr_pbmn bigint"    +                   /*  ���� �ŷ����                               */
			    ", fcam_mod_cls_code varchar(5)" +            /*  �׸鰡 ���� ���� �ڵ�                       */
				", revl_issu_reas_code varchar(5)" +          /*  ���� ���� ���� �ڵ�                       */
		        
			    ", orgn_ntby_qty bigint"     +                 /*  ����� ���ż�                               */
		        
			    //fnguide data
			    ", adj_prpr int"     +                      /*  �����ְ� (����:fnguide������ �߰�)          */
			    ", fn_oprc int"  +                          /*  �ֽ� �ð�                                   */
			    ", fn_hgpr int"    +                        /*  �ֽ� �ְ�                                 */
			    ", fn_lwpr int"     +                       /*  �ֽ� ������                                 */
			    ", fn_prpr int"      +                      /*  �ֽ� ����                                   */
			    ", fn_acml_vol bigint"   +                     /*  ���� �ŷ���                                 */
			    ", fn_acml_tr_pbmn bigint" +                   /*  ���� �ŷ� ���                              */
			    ", fn_prtt_rate float"      +                 /*  ���� ����                                   */
			    ", fn_flng_cls_code varchar(5)"  +            /*  ������ �ڵ�                                 */
			                                                /*  0-����,1-�Ǹ�,2-���,3-�ǹ��,              */
			                                                /*  4-�űԻ���,5-�׸����,6-���ֻ���,           */
			                                                /*  8-������űԻ���, 9-�ŷ����� : ������     */
		
			    // Buy-in ���� �߰� (2012.1.16)
			    ", buyin_nor_prpr int"      +               /* Buy-in �Ϲ� ü�ᰡ                           */
			    ", buyin_nor_prdy_vrss int" +               /* Buy-in �Ϲ� ���� ���                        */
			    ", buyin_nor_vol bigint"       +               /* Buy-in �Ϲ� ü�ᷮ                           */
			    ", buyin_nor_tr_pbmn bigint"   +               /* Buy-in �Ϲ� ü�� ���                        */
			    ", buyin_tod_prpr int"      +               /* Buy-in ���� ü�ᰡ                           */
			    ", buyin_tod_prdy_vrss int"  +              /* Buy-in ���� ���� ���                        */
			    ", buyin_tod_vol bigint"       +               /* Buy-in ���� ü�ᷮ                           */
			    ", buyin_tod_tr_pbmn bigint"   +              /* Buy-in ���� ü�� ���                        */
			    ", PRIMARY KEY(stnd_iscd, bsop_date)" +  /*���� primary key*/
				") DEFAULT CHARSET=utf8");		//���̺� ������
		
		stmt.close();
		conn.close();		//��������
	}

}