/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the License); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an AS IS BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.itcraft.frogspawn.impl;

import cn.itcraft.frogspawn.ObjectCreator;
import cn.itcraft.frogspawn.Resettable;

/**
 * @author Helly Guo
 * <p>
 * Created on 8/24/21 11:34 PM
 */
public class CachedLoopPoolImpl<T extends Resettable> extends AbstractCachedPool<T> {

    public CachedLoopPoolImpl(ObjectCreator<T> creator, int size) {
        super(creator, size);
    }

    @Override
    protected T fetchData() {
        return FetchHelper.loopFetchData(array, indexMask, walker);
    }

}
