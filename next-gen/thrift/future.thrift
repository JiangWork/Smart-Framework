/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


/**
 * The first thing to know about are types. The available types in Thrift are:
 *
 *  bool        Boolean, one byte
 *  byte        Signed byte
 *  i16         Signed 16-bit integer
 *  i32         Signed 32-bit integer
 *  i64         Signed 64-bit integer
 *  double      64-bit floating point value
 *  string      String
 *  binary      Blob (byte array)
 *  map<t1,t2>  Map from one type to another
 *  list<t1>    Ordered list of one type
 *  set<t1>     Set of unique elements of one type
 *
 */


namespace java com.klatencor.klara.future.thrift.common


struct Request {
  1: string who,
  2: map<string,string> parameters
}

struct TSenseSlider {
  1: string name,
  2: i32 type,
  3: double fValue,
  4: double fMin,
  5: double fMax,
  6: i32 value,
  7: i32 min,
  8: i32 max
}

struct TIntPoint {
   1: i32 x,
   2: i32 y,
}

struct TRecipeDescriptor {
   1: string name,
   2: string systemName,
   3: i32 version,
   4: i32 iaNum,
   6: list<TIntPoint> alignmentPoints,
}

struct TInspAreaDescriptor {
  1: i32 index,    // index in the ia array
  2: i32 iaId,
  3: string inspType,
  4: TIntPoint dieSize,
  5: TIntPoint diePitch,
  6: i32 columnCount,
  7: i32 rowCount,
  8: TIntPoint inspOrgin,
  9: string mode,
  10: i32 surface,
  11: list<TIntPoint> diePoints,
  13: i32 senseCount,
}


struct Response {
  1: bool status,
  2: string failure,
  3: map<string,string> ret
}

service FutureService {

    /**
    * store recipe for all versions.
    */
    Response storeRecipe(1:i64 time, 2:Request request),
    
    /**
    * shutdown the service.
    */
    oneway void shutdown(1:bool force),

    Response whatTime(),

    /**
    * generate XML for IR and recipe with all version support
    **/
    Response generateXML(1:i64 time, 2:string inPath, 3:string outPath, 4:string who),

    /**
    * get the server infomation, include startup date, memory usage, messages handled, job processed etc.
    */
    Response serverInfo(1:i64 time, 2:Request request),

    /**
    * get the job status, including running and completed jobs.
    */
    Response jobStatus(1:i64 time, 2:string who),

    /**
    * get the sensesliders of a selected recipe in specific inspeaction area 
    */
    list<TSenseSlider> getIaSenseSliders(1:i64 fmid, 2:i32 iaIndex),

    /**
    * get information of Recipe needed by KT9Xe using fmid
    **/
    TRecipeDescriptor getRecipeDescriptor(1:i64 fmid),

    /**
    * get infomation of Inspection Area needed by KT9Xe using fmid
    **/
    TInspAreaDescriptor getIaDescriptor(1:i64 fmid, 2:i32 iaIndex),

}

