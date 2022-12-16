package kr.or.ddit.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Scanner;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
   private static SqlMapClient smc;
   Scanner sc = new Scanner(System.in);

   static {
      Charset chrset = Charset.forName("utf-8");
      Resources.setCharset(chrset);

      Reader rd = null;
      try {
         rd = Resources.getResourceAsReader("kr/or/ddit/ibatis/config/sqlMapConfig.xml");
         smc = SqlMapClientBuilder.buildSqlMapClient(rd);
      } catch (IOException e) {
         e.printStackTrace();
      } finally {
         if (rd != null)
            try {
               rd.close();
            } catch (Exception e2) {
            }
      }
   }
   public static SqlMapClient getSqlMapClient() {
         return smc;
      }
   }